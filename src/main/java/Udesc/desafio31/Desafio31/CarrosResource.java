
package Udesc.desafio31.Desafio31;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class CarrosResource {
    
    @Autowired
    private CarroRepositorio carros;
    
    /**
     * Select por id
     * @param id pk da tabela
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Carro> buscar(@PathVariable Long id) {
       return carros.findById(id);
    }
    
    /**
     * Select de todos os registros da tabela
     * @return 
     */
    @GetMapping
    public List<Carro> pesquisar() {
        return carros.findAll();
    }
    
    /**
     * Salva um registro no banco de dados
     * @param carro valor a ser inserido, JSON
     * @return 
     */
    @PostMapping
    public Carro salvar(@RequestBody Carro carro) {
        return carros.save(carro);
    }
    
    /**
     * Deleta um registro do banco pelo ID
     * @param id valor referênte a PK do banco de dados
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        carros.deleteById(id);
    }
    
    /**
     * Update de um registro do banco de dados
     * @param query String SQL
     */
    @PutMapping("{query}")
    public static void update(@PathVariable String query) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("desafio3");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(query);
        System.out.println(q);
        q.executeUpdate();
    }
    
    /**
     * Select pela cor
     * @param query String SQL
     * @return lista correspondente a cor informada
     */
    @GetMapping("/cor/{query}")
    public List<Carro> selectCor(@PathVariable String query) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("desafio3");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select * from carro where cor = '" + (String) query + "'");
        System.out.println(q);
        return q.getResultList();
    }

    /**
     * Select pelo km
     * @param query String SQL
     * @return lista correspondente ao km informado
     */
    @GetMapping("/km/{query}")
    public List<Carro> selectKm(@PathVariable String query) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("desafio3");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select * from carro where km = '" + (String) query + "'");
        System.out.println(q);
        return q.getResultList();
    }

    /**
     * Select pelo modelo
     * @param query String SQL
     * @return lista correspondente ao modelo informado
     */
    @GetMapping("/modelo/{query}")
    public List<Carro> selectModelo(@PathVariable String query) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("desafio3");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select * from carro where modelo = '" + (String) query + "'");
        System.out.println(q);
        return q.getResultList();
    }

    /**
     * Select pela montadora
     * @param query String SQL
     * @return lista correspondente a montadora informada
     */
    @GetMapping("/montadora/{query}")
    public List<Carro> selectMontadora(@PathVariable String query) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("desafio3");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select * from carro where montadora = '" + (String) query + "'");
        System.out.println(q);
        return q.getResultList();
    }

    /**
     * Select pelp motor
     * @param query String SQL
     * @return lista correspondente ao motor informado
     */
    @GetMapping("/motor/{query}")
    public List<Carro> selectMotor(@PathVariable String query) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("desafio3");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select * from carro where motor = '" + (String) query + "'");
        System.out.println(q);
        return q.getResultList();
    }
}
