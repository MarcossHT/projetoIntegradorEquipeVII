package clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.TipoUsuario;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Usuario;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.EnderecoDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.TipoUsuarioDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.repository.ITipoUsuarioRepository;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoUsuarioServiceImpl implements IService<TipoUsuarioDTO> {

    @Autowired
    private ITipoUsuarioRepository tipoUsuarioRepository;


    @Override
    public TipoUsuarioDTO create(TipoUsuarioDTO tipoUsuarioDTO) {
        TipoUsuario tipoUsuario = new TipoUsuario(tipoUsuarioDTO);
        tipoUsuario = tipoUsuarioRepository.save(tipoUsuario);
        tipoUsuarioDTO = new TipoUsuarioDTO(tipoUsuario);
        return tipoUsuarioDTO;
    }

    @Override
    public TipoUsuarioDTO getById(int id) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(id).get();
        return new TipoUsuarioDTO(tipoUsuario);
    }

    @Override
    public String delete(int id) {
        tipoUsuarioRepository.deleteById(id);
        return "Usuario deletado " + id;
    }

    @Override
    public TipoUsuarioDTO update(TipoUsuarioDTO tipoUsuarioDTO) {
        TipoUsuario tipoUsuario = new TipoUsuario(tipoUsuarioDTO);
        tipoUsuario = tipoUsuarioRepository.saveAndFlush(tipoUsuario);
        tipoUsuarioDTO = new TipoUsuarioDTO(tipoUsuario);
        return tipoUsuarioDTO;
    }

    @Override
    public List<TipoUsuarioDTO> getAll() {
        List<TipoUsuario> tipoUsuarioList = tipoUsuarioRepository.findAll();
        List<TipoUsuarioDTO> tipoUsuarioDTOS = new ArrayList<>();

        for(TipoUsuario tipoUsuario: tipoUsuarioList) {
            TipoUsuarioDTO tipoUsuarioDTO = new TipoUsuarioDTO(tipoUsuario);
            tipoUsuarioDTOS.add(tipoUsuarioDTO);
        }
        return tipoUsuarioDTOS;
    }

    public boolean ifUsuarioExists(int id) { return tipoUsuarioRepository.existsById(id);}
}
