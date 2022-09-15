package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.UsuarioDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("/salvar")
    public UsuarioDTO create(@RequestParam UsuarioDTO usuarioDTO) {
        return usuarioService.create(usuarioDTO);
    }

    @GetMapping("/{id}")
    public UsuarioDTO getById(@PathVariable Integer id) {
        return usuarioService.getById(id);
    }

    @PutMapping()
    public UsuarioDTO update(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.update(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable int id) {
        return usuarioService.delete(id);
    }
}
