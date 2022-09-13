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

    /*public Integer getByName(String name) {
        return dentistaRepository.getByName(name);
    }*/


    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public DentistaDTO update(DentistaDTO dentistaDTO, int id) {
        /*Dentista dentista = new Dentista(dentistaDTO);
        dentista.setId(id);

        if(dentista.getId() != 0)
            dentistaRepository.create(dentista);*/

        return null;

    }

    public boolean ifDentistaExists(int id) {
        return dentistaRepository.existsById(id);
    }

    @Override
    public List<DentistaDTO> getAll() {
        /*List<Dentista> dentistaList = dentistaRepository.getAll();
        List<DentistaDTO> dentistaDTOS = new ArrayList<>();

        for(Dentista dentista: dentistaList) {
            DentistaDTO dentistaDTO = new DentistaDTO(dentista);
            dentistaDTOS.add(dentistaDTO);
        }*/
        return null;
    }
}

