package br.edu.yuniversidadedevassouras.SCP.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("admin", "$2a$12$2nlO2BAMBmSNjVLvQrNgDOWd7jTGFQvJbjAhrti77yOcXNbIcp6Ii", new ArrayList<>());
    }
}
