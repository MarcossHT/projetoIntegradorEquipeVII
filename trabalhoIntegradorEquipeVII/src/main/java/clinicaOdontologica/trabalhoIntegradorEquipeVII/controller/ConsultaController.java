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
        ResponseEntity responseEntity = null;

        if (consultaDTO.getData() != null) {
            ConsultaDTO consultaDTO1  = consultaService.create(consultaDTO);
            responseEntity = new ResponseEntity(consultaDTO1, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity("Data não preenchida", HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

     @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> getById(@PathVariable int id) {
        ResponseEntity responseEntity = null;

        ConsultaDTO consultaDTO = consultaService.getById(id);

        if (consultaDTO != null) {
            responseEntity = new ResponseEntity(consultaDTO, HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity("Consulta não existente", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;

    }

    @GetMapping
    public List<ConsultaDTO> getAll() {
        return consultaService.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable int id) {
        return consultaService.delete(id);
    }

    @PutMapping()
    public ConsultaDTO update(@RequestBody ConsultaDTO consultaDTO) {
        return consultaService.update(consultaDTO);
    }
}
