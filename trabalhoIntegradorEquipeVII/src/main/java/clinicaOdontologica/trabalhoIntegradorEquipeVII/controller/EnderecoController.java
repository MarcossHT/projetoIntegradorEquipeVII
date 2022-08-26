package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl.EnderecoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @GetMapping
    public Endereco salvar(@RequestParam(value = "id") Integer id,
                           @RequestParam(value = "rua") String rua,
                           @RequestParam(value = "numero") String numero,
                           @RequestParam(value = "bairro") String bairro,
                           @RequestParam(value = "cidade") String cidade,
                           @RequestParam(value = "estado") String estado) {
        return enderecoService.salvar(new Endereco(id, rua, numero, bairro, cidade, estado));
    }

    @GetMapping("/buscar")
    public List<Endereco> buscarTodos() {
        return enderecoService.buscarTodos();
    }

    @GetMapping("/{id}")
   public String excluir(@PathVariable Integer id) {
        return enderecoService.excluir(id);
    }
}
