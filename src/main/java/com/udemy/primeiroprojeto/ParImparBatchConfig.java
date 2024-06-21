package com.udemy.primeiroprojeto;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@EnableBatchProcessing
public class ParImparBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job imprimeParOuImparJob() {
        return jobBuilderFactory
                .get("imprimeParOuImparJob")
                .start(imprimeParOuImparStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }

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
        AtomicInteger count = new AtomicInteger();
        return new FunctionItemProcessor<>(
                numero -> {
                    if(count.get() == 3){
                        throw new NumberFormatException("Deu Ruim");
                    }
                    count.getAndIncrement();
                    return String.format("Numero %s é %s: ", numero, numero % 2 == 0 ? "PAR" : "IMPAR");
                }
        );
    }

    private ItemWriter<String> imprimeParOuImparWriter() {
        return numeros -> numeros.forEach(System.out::println);
    }

}
