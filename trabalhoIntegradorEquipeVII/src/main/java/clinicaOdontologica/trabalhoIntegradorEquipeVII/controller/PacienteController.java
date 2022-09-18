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

    @PostMapping("/salvar")
    public ResponseEntity<PacienteDTO> create(@RequestBody PacienteDTO pacienteDTO) {
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
    public ResponseEntity<PacienteDTO> getById(@PathVariable int id) {
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
    public List<PacienteDTO> getAll() {
        return pacienteService.getAll();
    }

    @DeleteMapping("/deletar/{id}")
    public String delete (@PathVariable int id) {
        return pacienteService.delete(id);
    }

    @PutMapping("/atualizar")
    public PacienteDTO update(@RequestBody PacienteDTO pacienteDTO) {
        return pacienteService.update(pacienteDTO);
    }

    @GetMapping("/getByNome")
    public PacienteDTO getByNome(@RequestParam(value = "nome") String nome) {
        return pacienteService.getByNome(nome);
    }
}
