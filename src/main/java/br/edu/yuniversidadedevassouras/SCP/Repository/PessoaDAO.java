package br.edu.yuniversidadedevassouras.SCP.Repository;

import br.edu.yuniversidadedevassouras.SCP.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaDAO extends CrudRepository<Pessoa, Long> {
}
