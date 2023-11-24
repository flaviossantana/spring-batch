package org.udemy.batch.aquivolargurafixa;

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
public class ArquivoLarguraFixaBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job arquivoLarguraFixaBatch(Step leituraArquivoLarguraFixa){
        return jobBuilderFactory
                .get("arquivoLarguraFixaBatch")
                .start(leituraArquivoLarguraFixa)
                .incrementer(new RunIdIncrementer())
                .build();
    }



}
