package org.udemy.batch.arquivodemilitado;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.udemy.batch.dto.Cliente;

@Configuration
public class ArquivoDemilitadoStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step arquivoDemilitadoStep(
            ItemReader<Cliente> arquivoDemilitadoReader,
            ItemWriter<Cliente> arquivoDemilitadoWrite) {

        return this.stepBuilderFactory
                .get("arquivoDemilitadoStep")
                .<Cliente, Cliente>chunk(1)
                .reader(arquivoDemilitadoReader)
                .writer(arquivoDemilitadoWrite)
                .build();
    }

}
