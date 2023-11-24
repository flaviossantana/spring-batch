package org.udemy.batch.aquivolargurafixa;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.udemy.batch.dto.Cliente;

@Configuration
public class LeituraArquivoLarguraFixaReaderConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<Cliente> leituraArquivoLarguraFixaReader(@Value("#{jobParameters['arquivoCliente']}") Resource arquivo) {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("leituraArquivoLarguraFixa")
                .resource(arquivo)
                .fixedLength()
                .columns(definePosicaoFixaColunas())
                .names("nome", "sobrenome", "idade", "email")
                .targetType(Cliente.class)
                .build();
    }

    private Range[] definePosicaoFixaColunas() {
        return new Range[]{
                new Range(1, 10),
                new Range(11, 20),
                new Range(21, 23),
                new Range(24, 43)};
    }


}
