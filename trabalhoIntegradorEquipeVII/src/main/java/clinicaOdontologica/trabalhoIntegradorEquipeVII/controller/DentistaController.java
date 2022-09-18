package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;


import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.ConsultaDTO;
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
    public ResponseEntity<DentistaDTO> create(@RequestBody DentistaDTO dentistaDTO) {
        ResponseEntity responseEntity = null;

        if (dentistaDTO.getNome() != null) {
            DentistaDTO dentistaDTO1  = dentistaService.create(dentistaDTO);
            responseEntity = new ResponseEntity(dentistaDTO1, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity("Data não preenchida", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistaDTO> getById(@PathVariable int id) {
        ResponseEntity responseEntity = null;

        DentistaDTO dentistaDTO = dentistaService.getById(id);

        if (dentistaDTO != null) {
            responseEntity = new ResponseEntity(dentistaDTO, HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity("Dentista não existente", HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @GetMapping
    public List<DentistaDTO> getAll() {
        return dentistaService.getAll();
    }

    @DeleteMapping("/deletar/{id}")
    public String delete (@PathVariable int id) {
        return dentistaService.delete(id);
    }

    @PutMapping("/atualizar")
    public DentistaDTO update(@RequestBody DentistaDTO dentistaDTO) {
        return dentistaService.update(dentistaDTO);
    }

    @GetMapping("/getByNome")
    public DentistaDTO getByNome(@RequestParam(value = "nome") String nome) {
        return dentistaService.getByNome(nome);
    };
}
