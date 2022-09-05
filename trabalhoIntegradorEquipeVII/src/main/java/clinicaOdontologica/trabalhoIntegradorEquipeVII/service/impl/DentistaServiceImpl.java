package clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Dentista;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.DentistaDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.repository.DentistaRepository;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DentistaServiceImpl implements IService<DentistaDTO> {

    @Autowired
    private DentistaRepository dentistaRepository;

    @Override
    public DentistaDTO create(DentistaDTO dentistaDTO) {
        Dentista dentista = new Dentista(dentistaDTO);
        dentistaRepository.create(dentista);
        return dentistaDTO;
    }

    @Override
    public DentistaDTO getById(int id) {
        return new DentistaDTO(dentistaRepository.getByid(id));
    }

    public Integer getByName(String name) {
        return dentistaRepository.getByName(name);
    }

    public int getIdDentista(int id) {
        return dentistaRepository.getId(id);
    }

    @Override
    public String delete(int id) {
        return dentistaRepository.delete(id);
    }

    @Override
    public DentistaDTO update(DentistaDTO dentistaDTO, int id) {
        Dentista dentista = new Dentista(dentistaDTO);
        dentista.setId(id);

        if(dentista.getId() != 0)
            dentistaRepository.create(dentista);

        return dentistaDTO;

    }

    @Override
    public List<DentistaDTO> getAll() {
        List<Dentista> dentistaList = dentistaRepository.getAll();
        List<DentistaDTO> dentistaDTOS = new ArrayList<>();

        for(Dentista dentista: dentistaList) {
            DentistaDTO dentistaDTO = new DentistaDTO(dentista);
            dentistaDTOS.add(dentistaDTO);
        }
        return dentistaDTOS;
    }
}

