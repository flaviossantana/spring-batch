package org.udemy.batch.dto;

import lombok.Data;

@Data
public class Cliente {
    private String nome;
    private String sobrenome;
    private String idade;
    private String email;
}
