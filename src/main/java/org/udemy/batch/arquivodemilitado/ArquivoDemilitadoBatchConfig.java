package org.udemy.batch.arquivodemilitado;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ArquivoDemilitadoBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job arquivoDemilitadoBatch(Step arquivoDemilitadoStep){
        return jobBuilderFactory
                .get("arquivoDemilitadoBatch")
                .start(arquivoDemilitadoStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
