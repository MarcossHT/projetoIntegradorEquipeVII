package clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.EnderecoDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.repository.EnderecoRepository;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EnderecoServiceImpl implements IService<EnderecoDTO> {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public EnderecoDTO create(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco(enderecoDTO);
        enderecoRepository.create(endereco);
        return enderecoDTO;
    }

    @Override
    public EnderecoDTO getById(int id) {
        return new EnderecoDTO(enderecoRepository.getById(id));
    }

    public int getIdEndereco(int id) {
        return enderecoRepository.getId(id);
    }


    @Override
    public String delete(int id) {
        return enderecoRepository.delete(id);
    }

    @Override
    public EnderecoDTO update(EnderecoDTO enderecoDTO, int id) {
        Endereco endereco = new Endereco(enderecoDTO);
        endereco.setId(id);

        if (endereco.getId() != 0)
            enderecoRepository.create(endereco);
        return enderecoDTO;
    }

    @Override
    public List<EnderecoDTO> getAll() {
        List<Endereco> enderecoList = enderecoRepository.getAll();
        List<EnderecoDTO> enderecoDTOS = new ArrayList<>();

        for (Endereco endereco : enderecoList) {
            EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
            enderecoDTOS.add(enderecoDTO);
        }
        return enderecoDTOS;
    }
}
