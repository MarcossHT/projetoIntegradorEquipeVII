package clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.EnderecoDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.repository.IEnderecoRepository;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements IService<EnderecoDTO> {

    @Autowired
    private IEnderecoRepository enderecoRepository;

    @Override
    public EnderecoDTO create(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco(enderecoDTO);
        endereco = enderecoRepository.save(endereco);
        enderecoDTO = new EnderecoDTO(endereco);
        return enderecoDTO;
    }

    @Override
    public EnderecoDTO getById(int id) {
        Endereco endereco = enderecoRepository.findById(id).get();
        return new EnderecoDTO(endereco);
    }

    /*public int getIdEndereco(int id) {
        return enderecoRepository.getId(id);
    }*/


    @Override
    public String delete(int id) {
        /*return enderecoRepository.delete(id);*/
        return null;
    }

    @Override
    public EnderecoDTO update(EnderecoDTO enderecoDTO, int id) {
        /*Endereco endereco = new Endereco(enderecoDTO);
        endereco.setId(id);

        if (endereco.getId() != 0)
            enderecoRepository.create(endereco);
        return enderecoDTO;*/
        return null;
    }

    @Override
    public List<EnderecoDTO> getAll() {
        /*List<Endereco> enderecoList = enderecoRepository.getAll();
        List<EnderecoDTO> enderecoDTOS = new ArrayList<>();

        for (Endereco endereco : enderecoList) {
            EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
            enderecoDTOS.add(enderecoDTO);
        }
        return enderecoDTOS;*/
        return null;
    }
    public boolean ifEnderecoExists(int id) {
        return enderecoRepository.existsById(id);
    }
}
