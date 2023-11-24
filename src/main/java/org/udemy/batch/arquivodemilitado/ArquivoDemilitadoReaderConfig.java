package org.udemy.batch.arquivodemilitado;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.udemy.batch.dto.Cliente;

@Configuration
public class ArquivoDemilitadoReaderConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<Cliente> arquivoDemilitadoReader(
            @Value("#{jobParameters['arquivoClienteDelimitado']}") Resource arquivo
    ){

        return new FlatFileItemReaderBuilder<Cliente>()
                .name("arquivoDemilitadoReader")
                .resource(arquivo)
                .delimited()
                .names("nome", "sobrenome", "idade", "email")
                .targetType(Cliente.class)
                .build();

    }

}
