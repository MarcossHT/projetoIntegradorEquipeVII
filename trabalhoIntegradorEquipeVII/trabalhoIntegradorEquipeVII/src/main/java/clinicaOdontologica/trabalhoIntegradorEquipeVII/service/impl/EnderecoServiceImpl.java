package clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.EnderecoDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.repository.IEnderecoRepository;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoServiceImpl implements IService<EnderecoDTO> {

    @Autowired
    private IEnderecoRepository enderecoRepository;

    @Override
    public EnderecoDTO create(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco(enderecoDTO);
        enderecoRepository.save(endereco);
        enderecoDTO = new EnderecoDTO(endereco);
        return enderecoDTO;
    }

    @Override
    public EnderecoDTO getById(int id) {
        Endereco endereco = enderecoRepository.findById(id).get();
        return new EnderecoDTO(endereco);
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public EnderecoDTO update(EnderecoDTO enderecoDTO, int id) {

        return null;
    }

    public boolean ifEnderecoExists(int id) {
        return enderecoRepository.existsById(id);
    }
    @Override
    public List<EnderecoDTO> getAll() {

        return null;
    }
}
