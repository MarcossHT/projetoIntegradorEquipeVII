package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Dentista;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    @GetMapping
    public Dentista salvar(@RequestParam(value = "id") Integer id,
                           @RequestParam(value = "nome") String nome,
                           @RequestParam(value = "sobrenome") String sobrenome,
                           @RequestParam(value = "matriculaCadastro") String matriculaCadastro) {
        return dentistaService.salvar(new Dentista(id, nome, sobrenome, matriculaCadastro));
    }

    @GetMapping("/buscar")
    public List<Dentista> buscarTodos() {
        return dentistaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public String excluir(@PathVariable Integer id) {
        return dentistaService.excluir(id);
    }
}
