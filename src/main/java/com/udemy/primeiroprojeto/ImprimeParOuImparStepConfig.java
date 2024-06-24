package com.udemy.primeiroprojeto;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ImprimeParOuImparStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step imprimeParOuImparStep() {
        return stepBuilderFactory
                .get("imprimeParOuImparStep")
                .<Integer, String>chunk(1)
                .reader(contaAteDezReader())
                .processor(parOuImparProcessor())
                .writer(imprimeParOuImparWriter())
                .build();
    }

    private IteratorItemReader<Integer> contaAteDezReader() {
        return new IteratorItemReader<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    private FunctionItemProcessor<Integer, String> parOuImparProcessor() {
        return new FunctionItemProcessor<>(numero ->
                String.format("Numero %s é %s: ", numero, numero % 2 == 0 ? "PAR" : "IMPAR")
        );
    }

    private ItemWriter<String> imprimeParOuImparWriter() {
        return numeros -> numeros.forEach(System.out::println);
    }

}