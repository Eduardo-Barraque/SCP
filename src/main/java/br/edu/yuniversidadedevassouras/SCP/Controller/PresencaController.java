package br.edu.yuniversidadedevassouras.SCP.Controller;

import br.edu.yuniversidadedevassouras.SCP.Repository.PresencaDAO;
import br.edu.yuniversidadedevassouras.SCP.model.Presenca;
import br.edu.yuniversidadedevassouras.SCP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/presenca")
@CrossOrigin
public class PresencaController {

    @Autowired
    private PresencaDAO presencaDAO;

    @GetMapping
    public Iterable<Presenca> getAll(){
        return presencaDAO.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Presenca> getPresenca(@PathVariable("id")Long id){
        return presencaDAO.findById(id);
    }

    @CrossOrigin
    @PostMapping
    public Presenca postPresenca(@RequestBody Presenca p){
        return  presencaDAO.save(p);
    }

    @DeleteMapping
    public void Delete(){
        presencaDAO.deleteAll();
    }

    @PutMapping
    public Presenca putPresenca(@RequestBody Presenca p){
        return  presencaDAO.save(p);
    }
}

