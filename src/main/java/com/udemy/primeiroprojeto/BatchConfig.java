package com.udemy.primeiroprojeto;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
                .incrementer(new RunIdIncrementer())
                .build();
    }

    public Step imprimeOlaMundoStep() {
        return stepBuilderFactory
                .get("imprimeOlaMundoStep")
                .tasklet(imprimeOlaTasklet(null))
                .build();
    }

    @Bean
    @StepScope
    public Tasklet imprimeOlaTasklet(@Value("#{jobParameters['nome-parametro']}") String nome) {
        return (contribution, chunkContext) -> {
            System.out.println("###### Olá: " + nome + " ######");
            return RepeatStatus.FINISHED;
        };
    }

}
