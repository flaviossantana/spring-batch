package org.udemy.batch.dto;

import lombok.Data;

@Data
public class Transacao {
    private String id;
    public String descricao;
    public Double valor;
}
