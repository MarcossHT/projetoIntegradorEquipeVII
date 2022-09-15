package clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Dentista;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.DentistaDTO;
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

    public DentistaDTO getByNome(String nome) {
        Dentista dentista = dentistaRepository.findByNome(nome);
        DentistaDTO dentistaDTO = new DentistaDTO(dentista);
        return dentistaDTO;
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
        return dentistaDTO;
    }
    @Override
    public List<DentistaDTO> getAll() {
        List<Dentista> dentistaList = dentistaRepository.findAll();
        List<DentistaDTO> dentistaDTOList = new ArrayList<>();
        for (Dentista dentista : dentistaList) {
            DentistaDTO dentistaDTO = new DentistaDTO(dentista);
            dentistaDTOList.add(dentistaDTO);
        }
        return dentistaDTOList;
    }
    public boolean ifDentistaExists(int id) {
        return dentistaRepository.existsById(id);
    }
}

