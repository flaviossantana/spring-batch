package org.udemy.batch.parouimpar;

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
import java.util.List;

@Configuration
@EnableBatchProcessing
public class ParOuImparbatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job imprimeParOuImparJob(){
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
                .processor(imprimeParOuImparProcessor())
                .writer(imprimeParOuImparWriter())
                .build();
    }

    private IteratorItemReader<Integer> contaAteDezReader() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return new IteratorItemReader<>(numeros.iterator());
    }

    private FunctionItemProcessor<Integer, String> imprimeParOuImparProcessor() {
        return new FunctionItemProcessor<>(
                numero -> numero % 2 == 0 ?
                        String.format("Item %s é PAR", numero) :
                        String.format("Item %s é IMPAR", numero));
    }

    private ItemWriter<? super String> imprimeParOuImparWriter() {
        return itens -> itens.forEach(System.out::println);
    }


}
