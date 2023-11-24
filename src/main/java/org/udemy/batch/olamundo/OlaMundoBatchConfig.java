package org.udemy.batch.olamundo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class OlaMundoBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job imprimeOlaMundoJob(@Qualifier("imprimeOlaMundoStepConfig") Step imprimeOlaMundoStepConfig){
        return jobBuilderFactory
                .get("imprimeOlaMundoJob")
                .start(imprimeOlaMundoStepConfig)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
