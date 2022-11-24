package br.edu.yuniversidadedevassouras.SCP.Controller;

import br.edu.yuniversidadedevassouras.SCP.Repository.PessoaDAO;
import br.edu.yuniversidadedevassouras.SCP.model.Pessoa;
import br.edu.yuniversidadedevassouras.SCP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/pessoa")
@CrossOrigin(maxAge = 3600)
public class PessoaController {

    @Autowired
    private PessoaDAO pessoaDAO;

    @Autowired
    private UserService userService;

    @GetMapping
    public Iterable<Pessoa> getAll(){
        return pessoaDAO.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Pessoa> getPessoa(@PathVariable("id")Long id){
        return pessoaDAO.findById(id);
    }

    @PostMapping
    public Pessoa postPessoa(@RequestBody Pessoa p){
        return  userService.salvar(p);
    }

    @DeleteMapping
    public void Delete(){
        pessoaDAO.deleteAll();
    }

    @PutMapping
    public Pessoa putPessoa(@RequestBody Pessoa p){
        return  userService.salvar(p);
    }
}

