
package Udesc.desafio31.Desafio31;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class CarrosResource {
    
    @Autowired
    private CarroRepositorio carros;
    
    @GetMapping("/{id}")
    public Optional<Carro> buscar(@PathVariable Long id) {
       return carros.findById(id);
    }
    
    @GetMapping
    public List<Carro> pesquisar() {
        return carros.findAll();
    }
    
    @PostMapping
    public Carro salvar(@RequestBody Carro carro) {
        return carros.save(carro);
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        carros.deleteById(id);
    }

}
