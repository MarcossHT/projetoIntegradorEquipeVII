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
    public ResponseEntity<List<ConsultaDTO>> getAll() {
        ResponseEntity responseEntity = null;
        List <ConsultaDTO> consultaList=  consultaService.getAll();
        if (consultaList != null) {
            responseEntity = new ResponseEntity(consultaList, HttpStatus.NOT_FOUND);
        }else {
            responseEntity = new ResponseEntity("Lista de consultas indisponível", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) {
        ResponseEntity responseEntity = null;
        String deleteId = consultaService.delete(id);
        if (deleteId != null) {
            responseEntity = new ResponseEntity(deleteId, HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity("Não é possível excluir uma consulta inexistente", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDTO> update(@RequestBody ConsultaDTO consultaDTO) {
        ResponseEntity responseEntity = null;
        ConsultaDTO consultaUpdate = consultaService.update(consultaDTO);
        if (consultaUpdate != null) {
            responseEntity = new ResponseEntity(consultaUpdate, HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity("Atualização não realizada! Dados inexistentes", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
