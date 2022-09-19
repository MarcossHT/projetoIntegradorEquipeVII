package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.exceptions.ProcessErrorException;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.exceptions.ResourceNotFoundException;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.TipoUsuarioDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl.TipoUsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioServiceImpl tipoUsuarioService;

    @PostMapping("/salvar")
    public ResponseEntity<TipoUsuarioDTO> create(@RequestBody TipoUsuarioDTO tipoUsuarioDTO) throws ProcessErrorException{
        try {
            return ResponseEntity.ok(tipoUsuarioService.create(tipoUsuarioDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Um erro interno aconteceu");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuarioDTO> getById(@PathVariable int id) throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(tipoUsuarioService.getById(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Tipo de usuario nao encontrado " + id);
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<TipoUsuarioDTO> update(@RequestBody TipoUsuarioDTO tipoUsuarioDTO) throws ProcessErrorException{
        try {
            return ResponseEntity.ok(tipoUsuarioService.update(tipoUsuarioDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Um erro interno aconteceu");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(tipoUsuarioService.delete(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Tipo de usuario nao encontrado " + id);
        }
    }

    @GetMapping
    public ResponseEntity<List<TipoUsuarioDTO>> getAll() throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(tipoUsuarioService.getAll());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Lista nao encontrada");
        }
    }

    public ResponseEntity<String> errorNotFound(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    public ResponseEntity<String> processError(ProcessErrorException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
