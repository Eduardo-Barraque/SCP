package br.edu.universidadedevassouras.SCP.service;

import br.edu.universidadedevassouras.SCP.model.Pessoa;

import java.util.List;

public interface PessoaService {

    Pessoa salvar(Pessoa pessoa);
    List<Pessoa> getAllPessoas();

}
