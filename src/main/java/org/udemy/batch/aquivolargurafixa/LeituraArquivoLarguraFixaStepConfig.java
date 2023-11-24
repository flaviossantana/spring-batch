package org.udemy.batch.aquivolargurafixa;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.udemy.batch.aquivolargurafixa.dto.Cliente;

@Configuration
public class LeituraArquivoLarguraFixaStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    @Primary
    public Step leituraArquivoLarguraFixa(
            ItemReader<Cliente> leituraArquivoLarguraFixaReader,
            ItemWriter<Cliente> leituraArquivoLarguraFixaWrite){

        return stepBuilderFactory
                .get("arquivoLarguraFixaStep")
                .<Cliente, Cliente>chunk(1)
                .reader(leituraArquivoLarguraFixaReader)
                .writer(leituraArquivoLarguraFixaWrite)
                .build();
    }


}
