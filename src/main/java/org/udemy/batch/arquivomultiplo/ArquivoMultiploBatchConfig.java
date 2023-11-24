package org.udemy.batch.arquivomultiplo;

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
public class ArquivoMultiploBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job arquivoMultiploBatch(Step arquivoMultiploStep){
        return this.jobBuilderFactory
                .get("arquivoMultiploBatch")
                .start(arquivoMultiploStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}
