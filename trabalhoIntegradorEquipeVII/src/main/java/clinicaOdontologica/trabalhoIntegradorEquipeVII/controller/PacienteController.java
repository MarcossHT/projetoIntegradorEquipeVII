package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.exceptions.ProcessErrorException;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.exceptions.ResourceNotFoundException;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.DentistaDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.PacienteDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    @PostMapping("/salvar")
    public ResponseEntity<PacienteDTO> create(@RequestBody PacienteDTO pacienteDTO) throws ProcessErrorException{
        try {
            return ResponseEntity.ok(pacienteService.create(pacienteDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Um erro interno aconteceu");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getById(@PathVariable int id) throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(pacienteService.getById(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Paciente nao encontrado " + id);
        }
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> getAll() throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(pacienteService.getAll());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Pacientes não encontrados");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(pacienteService.delete(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Paciente nao encontrado " + id);
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<PacienteDTO> update(@RequestBody PacienteDTO pacienteDTO) throws ProcessErrorException{
        try {
            return ResponseEntity.ok(pacienteService.update(pacienteDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Um erro interno aconteceu");
        }
    }

    @GetMapping("/getByNome")
    public ResponseEntity<PacienteDTO> getByNome(@RequestParam(value = "nome") String nome) throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(pacienteService.getByNome(nome));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Paciente nao encontrado");
        }
    }

    public ResponseEntity<String> errorNotFound(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    public ResponseEntity<String> processError(ProcessErrorException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
