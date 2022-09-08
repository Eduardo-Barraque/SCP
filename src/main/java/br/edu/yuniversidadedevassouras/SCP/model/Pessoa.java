package br.edu.yuniversidadedevassouras.SCP.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Idpessoa;
    @Column(nullable = false,unique = true)
    private String CPF;
    @Column(nullable = false)
    private String NOME;
    @Column(nullable = false,unique = true)
    private int MATRICULA;
    @Column(nullable = true)
    private Date NASCIMENTO;
    @Column(nullable = true)
    private char GENERO;
    @Column(nullable = true)

    @Lob
    private String FOTO;
}


