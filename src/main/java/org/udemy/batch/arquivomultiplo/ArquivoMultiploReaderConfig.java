package org.udemy.batch.arquivomultiplo;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ArquivoMultiploReaderConfig {

    @Bean
    @StepScope
    public FlatFileItemReader arquivoMultiploReader(
            @Value("#{jobParameters['arquivoMultiploFormato']}") Resource arquivo,
            LineMapper lineMapper
    ){
        return new FlatFileItemReaderBuilder()
                .name("arquivoMultiploReader")
                .resource(arquivo)
                .lineMapper(lineMapper)
                .build();
    }

}
