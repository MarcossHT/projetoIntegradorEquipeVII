package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;

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
    @PostMapping
    public ResponseEntity<PacienteDTO> create(@RequestParam PacienteDTO pacienteDTO) {
        ResponseEntity responseEntity = null;
        if (pacienteDTO.getNome() != null) {
            PacienteDTO pacienteDTO1 = pacienteService.create(pacienteDTO);
            responseEntity = new ResponseEntity(pacienteDTO1, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity("Nome não preenchido", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getById(@PathVariable Integer id) {
        ResponseEntity responseEntity = null;
        PacienteDTO pacienteDTO = pacienteService.getById(id);
        if (pacienteDTO != null) {
            responseEntity = new ResponseEntity(pacienteDTO, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity("Paciente não existente", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @GetMapping
    public ResponseEntity<List<PacienteDTO>> getAll() {
        ResponseEntity responseEntity = null;
        List<PacienteDTO> pacienteList=  pacienteService.getAll();
        if (pacienteList != null) {
            responseEntity = new ResponseEntity(pacienteList, HttpStatus.NOT_FOUND);
        }else {
            responseEntity = new ResponseEntity("Lista de pacientes indisponível", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) {
        ResponseEntity responseEntity = null;
        String deleteId = pacienteService.delete(id);
        if (deleteId != null) {
            responseEntity = new ResponseEntity(deleteId, HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity("Não é possível excluir um paciente inexistente", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> update(@RequestBody PacienteDTO pacienteDTO) {
        ResponseEntity responseEntity = null;
        PacienteDTO pacienteUpdate = pacienteService.update(pacienteDTO);
        if (pacienteUpdate != null) {
            responseEntity = new ResponseEntity(pacienteUpdate, HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity("Atualização não realizada! Dados inexistentes", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @GetMapping("/getByNome")
    public ResponseEntity <PacienteDTO> getByNome(@RequestParam(value = "nome") String nome) {
        ResponseEntity responseEntity = null;
        PacienteDTO pacienteDTO = pacienteService.getByNome(nome);
        if (pacienteDTO != null) {
            responseEntity = new ResponseEntity(pacienteDTO, HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity("Paciente não existente", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
