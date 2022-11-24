package br.edu.universidadedevassouras.SCP.service;

import br.edu.universidadedevassouras.SCP.repository.PessoaRepository;
import br.edu.universidadedevassouras.SCP.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements  PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public Pessoa salvar(Pessoa pessoa){

        return pessoaRepository.save(pessoa);
    }

    @Override
    public List<Pessoa> getAllPessoas() {

        return pessoaRepository.findAll();
    }
}
