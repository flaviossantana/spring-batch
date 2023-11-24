package org.udemy.batch.aquivolargurafixa;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.udemy.batch.aquivolargurafixa.dto.Cliente;

@Configuration
public class LeituraArquivoLarguraFixaWriteConfig {

    @Bean
    public ItemWriter<Cliente> leituraArquivoLarguraFixaWrite(){
        return items -> items.forEach(System.out::println);
    }

}
