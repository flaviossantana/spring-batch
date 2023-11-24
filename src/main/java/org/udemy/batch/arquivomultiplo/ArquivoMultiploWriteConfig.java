package org.udemy.batch.arquivomultiplo;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoMultiploWriteConfig {

    @Bean
    public ItemWriter arquivoMultiploWrite(){
        return itens -> itens.forEach(System.out::println);
    }

}
