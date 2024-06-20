package com.udemy.primeiroprojeto;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job imprimiOlaJob() {
        return jobBuilderFactory
                .get("imprimiOlaJob")
                .start(imprimeOlaMundoStep())
                .build();
    }

    @Bean
    public Step imprimeOlaMundoStep() {
        return stepBuilderFactory
                .get("imprimeOlaMundoStep")
                .tasklet((contribution, chunkContext) -> {
                    System.out.printf("Olá mundo!");
                    return RepeatStatus.FINISHED;})
                .build();
    }

}
