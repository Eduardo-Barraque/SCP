package br.edu.yuniversidadedevassouras.SCP.service;

import br.edu.yuniversidadedevassouras.SCP.model.Pessoa;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface PessoaService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    public Pessoa salvar(Pessoa pessoa);
    public List<Pessoa> getAllPessoas();

}
