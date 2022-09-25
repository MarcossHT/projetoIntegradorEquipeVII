package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;


import clinicaOdontologica.trabalhoIntegradorEquipeVII.exceptions.ProcessErrorException;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.exceptions.ResourceNotFoundException;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.EnderecoDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl.EnderecoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoServiceImpl enderecoService;


    @PostMapping("/salvar")
    public ResponseEntity<EnderecoDTO> create(@RequestBody EnderecoDTO enderecoDTO) throws ProcessErrorException{
        try {
            return ResponseEntity.ok(enderecoService.create(enderecoDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Um erro interno aconteceu");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> getById(@PathVariable int id) throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(enderecoService.getById(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Endereco nao encontrado " + id);
        }
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> getAll() throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(enderecoService.getAll());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Enderecos nao encontrados");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) throws ResourceNotFoundException{
        try {
            return ResponseEntity.ok(enderecoService.delete(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Endereco nao encontrado " + id);
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<EnderecoDTO> update(@RequestBody EnderecoDTO enderecoDTO) throws ProcessErrorException{
        try {
            return ResponseEntity.ok(enderecoService.update(enderecoDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Um erro interno aconteceu");
        }
    }
}
