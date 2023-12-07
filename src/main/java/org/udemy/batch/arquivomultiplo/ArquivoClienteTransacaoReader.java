package org.udemy.batch.arquivomultiplo;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.udemy.batch.dto.Cliente;
import org.udemy.batch.dto.Transacao;

public class ArquivoClienteTransacaoReader implements ItemStreamReader<Cliente> {

    private Object atual;

    @Override
    public Cliente read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        if (atual == null) {
            //TODO: ler o objeto
        }

        Cliente cliente = (Cliente) atual;

        if (cliente != null) {
            while (peek() instanceof Transacao) {
                cliente.getTransacoes().add((Transacao) atual);
            }
        }

        return cliente;
    }

    private Object peek() {

        //TODO: leitura do próximo item

        return atual;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {

    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {

    }

    @Override
    public void close() throws ItemStreamException {

    }
}
