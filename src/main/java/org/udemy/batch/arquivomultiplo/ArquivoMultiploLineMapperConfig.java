package org.udemy.batch.arquivomultiplo;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.udemy.batch.dto.Cliente;
import org.udemy.batch.dto.Transacao;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ArquivoMultiploLineMapperConfig {

    @Bean
    public PatternMatchingCompositeLineMapper lineMapper(){
        PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper<>();
        lineMapper.setTokenizers(lineTokenizer());
        lineMapper.setFieldSetMappers(fieldSetMappers());

        return lineMapper;
    }

    private Map<String, LineTokenizer> lineTokenizer(){
        Map<String, LineTokenizer> tokenizers = new HashMap<>();
        tokenizers.put("0*", clienteLineTokenize());
        tokenizers.put("1*", transacaoLineTokenize());
        return tokenizers;
    }

    private LineTokenizer clienteLineTokenize() {
        DelimitedLineTokenizer clienteLineTokenizer = new DelimitedLineTokenizer();
        clienteLineTokenizer.setNames("nome", "sobrenome", "idade", "email");
        clienteLineTokenizer.setIncludedFields(1,2,3,4);
        return clienteLineTokenizer;
    }

    private LineTokenizer transacaoLineTokenize() {
        DelimitedLineTokenizer transacaoLineTokenizer = new DelimitedLineTokenizer();
        transacaoLineTokenizer.setNames("id", "descrcao", "valor");
        transacaoLineTokenizer.setIncludedFields(1,2,3);
        return transacaoLineTokenizer;
    }

    private Map<String, FieldSetMapper> fieldSetMappers() {
        Map<String, FieldSetMapper> fieldSetMapperMap = new HashMap<>();
        fieldSetMapperMap.put("0*", fieldSetMapper(Cliente.class));
        fieldSetMapperMap.put("1*", fieldSetMapper(Transacao.class));
        return fieldSetMapperMap;
    }

    private FieldSetMapper fieldSetMapper(Class<?> classe) {
        BeanWrapperFieldSetMapper  fieldSetMapper = new BeanWrapperFieldSetMapper();
        fieldSetMapper.setTargetType(classe);
        return fieldSetMapper;
    }







}
