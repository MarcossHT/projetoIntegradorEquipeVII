package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.UsuarioDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("/salvar")
    public UsuarioDTO create(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.create(usuarioDTO);
    }

    @GetMapping("/{id}")
    public UsuarioDTO getById(@PathVariable int id) {
        return usuarioService.getById(id);
    }

    @PutMapping("/atualizar")
    public UsuarioDTO update(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.update(usuarioDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public String delete (@PathVariable int id) {
        return usuarioService.delete(id);
    }

    @GetMapping
    public List<UsuarioDTO> getAll() {return usuarioService.getAll();}
}
