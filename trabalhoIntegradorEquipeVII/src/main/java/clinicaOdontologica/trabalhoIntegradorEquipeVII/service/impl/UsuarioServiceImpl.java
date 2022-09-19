package clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.TipoUsuario;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Usuario;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.TipoUsuarioDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.UsuarioDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.repository.IUsuarioRepository;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements IService<UsuarioDTO> {

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    TipoUsuarioServiceImpl tipoUsuarioService;

    @Override
    public UsuarioDTO create(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        TipoUsuarioDTO tipoUsuarioDTO;
        int idTipoUsuario = usuario.getTipoUsuario().getId();

        if (tipoUsuarioService.ifUsuarioExists(idTipoUsuario)) {
            tipoUsuarioDTO = tipoUsuarioService.getById(idTipoUsuario);
            TipoUsuario tipoUsuario = new TipoUsuario(tipoUsuarioDTO);
            usuario.setTipoUsuario(tipoUsuario);
            usuario = usuarioRepository.save(usuario);
        }

        usuarioDTO = new UsuarioDTO(usuario);
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO getById(int id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        return usuarioDTO;
    }

    @Override
    public String delete(int id) {
        usuarioRepository.deleteById(id);
        return "Usuario deletado " + id;
    }

    @Override
    public UsuarioDTO update(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        usuario = usuarioRepository.saveAndFlush(usuario);
        usuarioDTO = new UsuarioDTO(usuario);
        return usuarioDTO;
    }

    @Override
    public List<UsuarioDTO> getAll() {
        List<Usuario> usuarioList = usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();

        for (Usuario usuario: usuarioList) {
            UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
            usuarioDTOS.add(usuarioDTO);
        }
        return usuarioDTOS;
    }

    public boolean ifUsuarioExists(int id){
        return usuarioRepository.existsById(id);
    }

    public UsuarioDTO getByNome(String nome) {
        Usuario usuario = usuarioRepository.findByNome(nome);
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        return usuarioDTO;
    }
}
