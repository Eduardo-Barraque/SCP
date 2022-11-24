package br.edu.universidadedevassouras.SCP.repository;

import br.edu.universidadedevassouras.SCP.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
