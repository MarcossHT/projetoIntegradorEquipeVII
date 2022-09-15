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
    public List<EnderecoDTO> getAll() {
        return enderecoService.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable int id) {
        return enderecoService.delete(id);
    }

    @PutMapping()
    public EnderecoDTO update(@RequestBody EnderecoDTO enderecoDTO) {
        return enderecoService.update(enderecoDTO);
    }
}
