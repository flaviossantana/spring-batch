package org.udemy.batch.arquivodemilitado;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.udemy.batch.dto.Cliente;

@Configuration
public class ArquivoDemilitadoWriteConfig {

    @Bean
    public ItemWriter<Cliente> arquivoDemilitadoWrite(){
        return itens -> itens.forEach(System.out::println);
    }

}
