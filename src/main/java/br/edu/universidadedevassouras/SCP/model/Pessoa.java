package br.edu.universidadedevassouras.SCP.model;

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
    private int Idpessoa;
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

    public int getIdpessoa() {
        return Idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        Idpessoa = idpessoa;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public int getMATRICULA() {
        return MATRICULA;
    }

    public void setMATRICULA(int MATRICULA) {
        this.MATRICULA = MATRICULA;
    }

    public Date getNASCIMENTO() {
        return NASCIMENTO;
    }

    public void setNASCIMENTO(Date NASCIMENTO) {
        this.NASCIMENTO = NASCIMENTO;
    }

    public char getGENERO() {
        return GENERO;
    }

    public void setGENERO(char GENERO) {
        this.GENERO = GENERO;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFOTO() {
        return FOTO;
    }

    public void setFOTO(String FOTO) {
        this.FOTO = FOTO;
    }
}


