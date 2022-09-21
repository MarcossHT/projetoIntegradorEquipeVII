package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;



import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.ConsultaDTO;import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.EnderecoDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaServiceImpl consultaService;

    @PostMapping
    public ResponseEntity<ConsultaDTO> create(@RequestParam ConsultaDTO consultaDTO) {
        throws ProcessErrorException {
            try {
                return ResponseEntity.ok(consultaService.create(consultaDTO));
            } catch (Exception e) {
                throw new ProcessErrorException("Um erro interno aconteceu");
            }
        }
    }
     @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> getById(@PathVariable int id)
     throws ResourceNotFoundException {
         try {
             return ResponseEntity.ok(consultaService.getById(id));
         } catch (Exception e) {
             throw new ResourceNotFoundException("Consulta nao encontrada" + id);
         }
     }

    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> getAll() throws ResourceNotFoundException {
        try{
            return ResponseEntity.ok(consultaService.getAll());
        }catch (Exception e) {
            throw new ResourceNotFoundException ("Consulta nao encontrada");
        }
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(consultaService.delete(id));
        }catch (Exception e) {
            throw new ResourceNotFoundException("Consulta nao encontrada" + id);
        }
     }

    @PutMapping("/atualizar")
    public ResponseEntity<ConsultaDTO> update(@RequestBody ConsultaDTO consultaDTO)
        throws ProcessErrorException {
        try {
            return ResponseEntity.ok(consultaService.update(consultaDTO));
        }catch (Exception e) {
            throw new ProcessErrorException("Um erro interno aconteceu");
        }
    }

    public ResponseEntity<String> errorNotfouind(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    public ResponseEntity<String> processError(ProcessErrorException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
