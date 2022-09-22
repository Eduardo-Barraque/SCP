package br.edu.yuniversidadedevassouras.SCP.model;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    private String username;
    @Column(unique = true,nullable = false)
    private String senha;
    @Column(nullable = true)

    @Lob
    private String FOTO;



}


