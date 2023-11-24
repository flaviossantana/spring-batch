package org.udemy.batch.arquivomultiplo;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoMultiploWriteConfig {

    @Bean
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ItemWriter arquivoMultiploWrite(){
        return itens -> itens.forEach(System.out::println);
    }

}
