package br.edu.yuniversidadedevassouras.SCP.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Presenca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPresenca;
    @Column(nullable = false)
    private Date DATA;
    @Column(nullable = false)
    private Boolean SITUACAO;
    @ManyToOne
    private Pessoa pessoa;
}
