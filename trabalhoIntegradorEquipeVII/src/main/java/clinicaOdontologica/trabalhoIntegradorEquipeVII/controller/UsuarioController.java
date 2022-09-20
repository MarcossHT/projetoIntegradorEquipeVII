package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.exceptions.ProcessErrorException;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.exceptions.ResourceNotFoundException;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.UsuarioDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO) throws ProcessErrorException{
        try {
            return ResponseEntity.ok(usuarioService.create(usuarioDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Um erro interno aconteceu");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable int id) throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(usuarioService.getById(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Usuario nao encontrado " + id);
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuarioDTO) throws ProcessErrorException{
        try {
            return ResponseEntity.ok(usuarioService.update(usuarioDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Um erro interno aconteceu");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(usuarioService.delete(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Usuario nao encontrado " + id);
        }
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll() throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(usuarioService.getAll());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Lista de usuarios nao encontrada");
        }
    }

    public ResponseEntity<String> errorNotFound(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    public ResponseEntity<String> processError(ProcessErrorException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
