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

    @PostMapping
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
    public ResponseEntity<DentistaDTO> getById(@PathVariable Integer id) {
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
    public ResponseEntity<List<DentistaDTO>> getAll() {
        ResponseEntity responseEntity = null;
        List <DentistaDTO> dentistaList=  dentistaService.getAll();
        if (dentistaList != null) {
            responseEntity = new ResponseEntity(dentistaList, HttpStatus.NOT_FOUND);
        }else {
            responseEntity = new ResponseEntity("Lista de dentistas indisponível", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) {
        ResponseEntity responseEntity = null;
        String deleteId = dentistaService.delete(id);
        if (deleteId != null) {
            responseEntity = new ResponseEntity(deleteId, HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity("Não é possível excluir um dentista inexistente", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @PutMapping("/{id}")
    public ResponseEntity<DentistaDTO> update(@RequestBody DentistaDTO dentistaDTO) {
        ResponseEntity responseEntity = null;
        DentistaDTO dentistaUpdate = dentistaService.update(dentistaDTO);
        if (dentistaUpdate != null) {
            responseEntity = new ResponseEntity(dentistaUpdate, HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity("Atualização não realizada! Dados inexistentes", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @GetMapping("/getByNome")
    public ResponseEntity <DentistaDTO> getByNome(@RequestParam(value = "nome") String nome) {
        ResponseEntity responseEntity = null;
        DentistaDTO dentistaDTO = dentistaService.getByNome(nome);
        if (dentistaDTO != null) {
            responseEntity = new ResponseEntity(dentistaDTO, HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity("Dentista não existente", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
