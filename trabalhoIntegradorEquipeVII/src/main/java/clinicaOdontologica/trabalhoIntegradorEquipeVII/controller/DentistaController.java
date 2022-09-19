package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;


import clinicaOdontologica.trabalhoIntegradorEquipeVII.exceptions.ProcessErrorException;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.exceptions.ResourceNotFoundException;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.DentistaDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    @PostMapping("/salvar")
    public ResponseEntity<DentistaDTO> create(@RequestBody DentistaDTO dentistaDTO) throws ProcessErrorException{
        try {
            return ResponseEntity.ok(dentistaService.create(dentistaDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Um erro interno aconteceu");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistaDTO> getById(@PathVariable int id) throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(dentistaService.getById(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Dentista nao encotrado " + id);
        }
    }

    @GetMapping
    public ResponseEntity<List<DentistaDTO>> getAll() throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(dentistaService.getAll());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Dentistas nao encontrados");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(dentistaService.delete(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Dentista nao encotrado " + id);
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<DentistaDTO> update(@RequestBody DentistaDTO dentistaDTO) throws ProcessErrorException{
        try {
            return ResponseEntity.ok(dentistaService.update(dentistaDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Um erro interno aconteceu");
        }
    }

    @GetMapping("/getByNome")
    public ResponseEntity<DentistaDTO> getByNome(@RequestParam(value = "nome") String nome) throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(dentistaService.getByNome(nome));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Dentista nao encotrado");
        }
    };

    public ResponseEntity<String> errorNotFound(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    public ResponseEntity<String> processError(ProcessErrorException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
