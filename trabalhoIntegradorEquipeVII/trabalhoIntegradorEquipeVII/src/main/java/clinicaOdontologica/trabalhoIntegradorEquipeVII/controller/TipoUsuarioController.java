package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.TipoUsuarioDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl.TipoUsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioServiceImpl tipoUsuarioService;

    @PostMapping("/salvar")
    public TipoUsuarioDTO create(@RequestParam TipoUsuarioDTO tipoUsuarioDTO) {
        return tipoUsuarioService.create(tipoUsuarioDTO);
    }

    @GetMapping("/{id}")
    public TipoUsuarioDTO getById(@PathVariable Integer id) {
        return tipoUsuarioService.getById(id);
    }

    @PutMapping()
    public TipoUsuarioDTO update(@RequestBody TipoUsuarioDTO tipoUsuarioDTO) {
        return tipoUsuarioService.update(tipoUsuarioDTO);
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable int id) {
        return tipoUsuarioService.delete(id);
    }
}
