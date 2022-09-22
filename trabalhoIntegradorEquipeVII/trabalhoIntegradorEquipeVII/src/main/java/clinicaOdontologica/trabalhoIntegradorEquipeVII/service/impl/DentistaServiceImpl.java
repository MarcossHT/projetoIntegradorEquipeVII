package clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Dentista;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Usuario;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.DentistaDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.UsuarioDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.repository.IDentistaRepository;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DentistaServiceImpl implements IService<DentistaDTO> {

    @Autowired
    private IDentistaRepository dentistaRepository;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Override
    public DentistaDTO create(DentistaDTO dentistaDTO) {
        Dentista dentista = new Dentista(dentistaDTO);
        dentista = dentistaRepository.save(dentista);
        dentistaDTO = new DentistaDTO(dentista);
        return dentistaDTO;
    }

    @Override
    public DentistaDTO getById(int id) {
        Dentista dentista = dentistaRepository.findById(id).get();
        return new DentistaDTO(dentista);
    }

    @Override
    public String delete(int id) {
        dentistaRepository.deleteById(id);
        return "Dentista deletado " + id;
    }

    @Override
    public DentistaDTO update(DentistaDTO dentistaDTO) {
        Dentista dentista = new Dentista(dentistaDTO);
        dentistaRepository.saveAndFlush(dentista);
        dentistaDTO = new DentistaDTO(dentista);
        return dentistaDTO;
    }

    public boolean ifDentistaExists(int id) {
        return dentistaRepository.existsById(id);
    }

    @Override
    public List<DentistaDTO> getAll() {
        List<Dentista> dentistaList = dentistaRepository.findAll();
        List<DentistaDTO> dentistaDTOS = new ArrayList<>();

        for (Dentista dentista: dentistaList) {
            DentistaDTO dentistaDTO = new DentistaDTO(dentista);
            dentistaDTOS.add(dentistaDTO);
        }
        return dentistaDTOS;
    }

    public DentistaDTO getByNome(String nome) {
        Dentista dentista = dentistaRepository.findByNome(nome);
        DentistaDTO dentistaDTO = new DentistaDTO(dentista);
        return dentistaDTO;
    }
}

