package org.udemy.batch.arquivomultiplo;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoMultiploStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step arquivoMultiploStep(
            FlatFileItemReader arquivoMultiploReader,
            ItemWriter arquivoMultiploWrite){

        return this.stepBuilderFactory
                .get("arquivoMultiploStep")
                .chunk(1)
                .reader(arquivoMultiploReader)
                .writer(arquivoMultiploWrite)
                .build();

    }

}
