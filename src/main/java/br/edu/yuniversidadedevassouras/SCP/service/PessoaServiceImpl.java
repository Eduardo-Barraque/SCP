package br.edu.yuniversidadedevassouras.SCP.service;

import br.edu.yuniversidadedevassouras.SCP.Repository.PessoaDAO;
import br.edu.yuniversidadedevassouras.SCP.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaServiceImpl implements  PessoaService {

    @Autowired
    private PessoaDAO pessoaDAO;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Pessoa usuario = pessoaDAO.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário com o nome: " + username + "não encontrado");
        }

        return new User(usuario.getUsername(), usuario.getSenha(), new ArrayList<>());
    }

    public Pessoa salvar(Pessoa pessoa){
        return pessoaDAO.save(pessoa);
    }

    @Override
    public List<Pessoa> getAllPessoas() {
        return (List<Pessoa>) pessoaDAO.findAll();
    }
}
