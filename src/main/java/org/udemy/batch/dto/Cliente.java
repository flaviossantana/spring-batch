package org.udemy.batch.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {
    private String nome;
    private String sobrenome;
    private String idade;
    private String email;
    private List<Transacao> transacoes;

    public List<Transacao> getTransacoes() {
        if (transacoes == null) {
            transacoes = new ArrayList<>();
        }
        return transacoes;
    }
}
