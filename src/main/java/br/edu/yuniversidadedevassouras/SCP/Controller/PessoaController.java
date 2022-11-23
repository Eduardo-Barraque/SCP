package br.edu.yuniversidadedevassouras.SCP.Controller;

import br.edu.yuniversidadedevassouras.SCP.Repository.PessoaDAO;
import br.edu.yuniversidadedevassouras.SCP.model.Pessoa;
import br.edu.yuniversidadedevassouras.SCP.service.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(maxAge = 3600)
public class PessoaController {

    @Autowired
    private PessoaDAO pessoaDAO;

    @Autowired
    private PessoaServiceImpl pessoaServiceImpl;

    @GetMapping
    public List<Pessoa> getAllPessoas(){
        return pessoaServiceImpl.getAllPessoas();
    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Pessoa> getPessoa(@PathVariable("id")Long id){
        return pessoaDAO.findById(id);
    }

    @PostMapping("/add")
    public String postPessoa(@RequestBody Pessoa pessoa){
        pessoaServiceImpl.salvar(pessoa);
        return "Nova pessoa adicionada";
    }

    @DeleteMapping
    public void Delete(){ pessoaDAO.deleteAll();
    }

    @PutMapping
    public Pessoa putPessoa(@RequestBody Pessoa p){
        return  pessoaServiceImpl.salvar(p);
    }
}

