package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.TipoUsuarioDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl.TipoUsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioServiceImpl tipoUsuarioService;

    @PostMapping("/salvar")
    public TipoUsuarioDTO create(@RequestBody TipoUsuarioDTO tipoUsuarioDTO) {
        return tipoUsuarioService.create(tipoUsuarioDTO);
    }

    @GetMapping("/{id}")
    public TipoUsuarioDTO getById(@PathVariable int id) {
        return tipoUsuarioService.getById(id);
    }

    @PutMapping("/atualizar")
    public TipoUsuarioDTO update(@RequestBody TipoUsuarioDTO tipoUsuarioDTO) {
        return tipoUsuarioService.update(tipoUsuarioDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public String delete (@PathVariable int id) {
        return tipoUsuarioService.delete(id);
    }

    @GetMapping
    public List<TipoUsuarioDTO> getAll() {return tipoUsuarioService.getAll();}
}
