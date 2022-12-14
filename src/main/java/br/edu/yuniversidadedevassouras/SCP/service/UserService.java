package br.edu.yuniversidadedevassouras.SCP.service;

import br.edu.yuniversidadedevassouras.SCP.Repository.PessoaDAO;
import br.edu.yuniversidadedevassouras.SCP.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PessoaDAO pessoaDAO;

    @Autowired
    private PasswordEncoder senhaencrypt;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Pessoa usuario = pessoaDAO.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário com o nome: " + username + "não encontrado");
        }

        return new User(usuario.getUsername(), usuario.getSenha(), new ArrayList<>());
    }
    public Pessoa salvar(Pessoa pessoa){
        pessoa.setSenha(senhaencrypt.encode(pessoa.getSenha()));
        return pessoaDAO.save(pessoa);
    }
}
