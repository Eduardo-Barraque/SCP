package br.edu.universidadedevassouras.SCP.Controller;

import br.edu.universidadedevassouras.SCP.repository.PessoaRepository;
import br.edu.universidadedevassouras.SCP.model.Pessoa;
import br.edu.universidadedevassouras.SCP.service.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(maxAge = 3600)
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaServiceImpl pessoaServiceImpl;

    @GetMapping("/getAll")
    public List<Pessoa> getAllPessoas(){

        return pessoaServiceImpl.getAllPessoas();
    }

    @PostMapping
    public String postPessoa(@RequestBody Pessoa pessoa){
        pessoaServiceImpl.salvar(pessoa);
        return "Nova pessoa adicionada";
    }

    @DeleteMapping
    public void Delete(){ pessoaRepository.deleteAll();
    }

    @PutMapping
    public Pessoa putPessoa(@RequestBody Pessoa p){

        return  pessoaServiceImpl.salvar(p);
    }
}

