package br.edu.yuniversidadedevassouras.SCP.Repository;

import br.edu.yuniversidadedevassouras.SCP.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaDAO extends CrudRepository<Pessoa, Long> {
    Pessoa findByUsername(String username);
}
