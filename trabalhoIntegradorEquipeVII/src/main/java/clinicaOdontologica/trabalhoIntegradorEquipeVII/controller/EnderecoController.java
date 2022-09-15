package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;


import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.DentistaDTO;
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

    @PostMapping
    public ResponseEntity<EnderecoDTO> create(@RequestParam EnderecoDTO enderecoDTO) {
        ResponseEntity responseEntity = null;

        if (enderecoDTO.getRua() != null) {
            EnderecoDTO enderecoDTO1 = enderecoService.create(enderecoDTO);
            responseEntity = new ResponseEntity(enderecoDTO1, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity("Data não preenchida", HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> getById(@PathVariable Integer id) {
        ResponseEntity responseEntity = null;
        EnderecoDTO enderecoDTO = enderecoService.getById(id);
        if (enderecoDTO != null) {
            responseEntity = new ResponseEntity(enderecoDTO, HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity("Endereco não existente", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> getAll() {
        ResponseEntity responseEntity = null;
        List<EnderecoDTO> enderecoList = enderecoService.getAll();
        if (enderecoList != null) {
            responseEntity = new ResponseEntity(enderecoList, HttpStatus.NOT_FOUND);
        } else {
            responseEntity = new ResponseEntity("Lista de endereços indisponível", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) {
        ResponseEntity responseEntity = null;
        String deleteId = enderecoService.delete(id);
        if (deleteId != null) {
            responseEntity = new ResponseEntity(deleteId, HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity("Não é possível excluir um endereço inexistente", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO>update(@RequestBody EnderecoDTO enderecoDTO) {
        ResponseEntity responseEntity = null;
        EnderecoDTO enderecoUpdate = enderecoService.update(enderecoDTO);
        if (enderecoUpdate != null) {
            responseEntity = new ResponseEntity(enderecoUpdate, HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity("Atualização não realizada! Dados inexistentes", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
