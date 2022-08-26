package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    @GetMapping
    public Paciente salvar(@RequestParam(value = "id") Integer id,
                           @RequestParam(value = "nome") String nome,
                           @RequestParam(value = "sobrenome") String sobrenome,
                           @RequestParam(value = "idEndereco") Integer idEndereco,
                           @RequestParam(value = "rg") String rg,
                           @RequestParam(value = "dataDeAlta") String dataDeAlta) {
        return pacienteService.salvar(new Paciente(id, nome, sobrenome, idEndereco, rg, dataDeAlta));
    }

    @GetMapping("/buscar")
    public List<Paciente> buscarTodos() {
        return pacienteService.buscarTodos();
    }

    @GetMapping("/{id}")
    public String excluir(@RequestParam Integer id) {
        return pacienteService.excluir(id);
    }
}
