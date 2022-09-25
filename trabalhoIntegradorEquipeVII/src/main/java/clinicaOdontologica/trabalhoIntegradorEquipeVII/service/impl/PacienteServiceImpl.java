package clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Usuario;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.EnderecoDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.PacienteDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.UsuarioDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.repository.IPacienteRepository;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteServiceImpl implements IService<PacienteDTO> {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Override
    public PacienteDTO create(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente(pacienteDTO);
        EnderecoDTO enderecoDTO;
        int idEndereco = paciente.getEndereco().getId();
        if (enderecoService.ifEnderecoExists(idEndereco)) {
            enderecoDTO = enderecoService.getById(idEndereco);
            Endereco endereco = new Endereco(enderecoDTO);
            paciente.setEndereco(endereco);
            paciente = pacienteRepository.save(paciente);
        }
        pacienteDTO = new PacienteDTO(paciente);
        return pacienteDTO;
    }

    @Override
    public PacienteDTO getById(int id) {
        Paciente paciente = pacienteRepository.findById(id).get();
        PacienteDTO pacienteDTO = new PacienteDTO(paciente);
        return pacienteDTO;
    }


    public boolean ifPacienteExists(int id) {
        return pacienteRepository.existsById(id);
    }


    @Override
    public String delete(int id) {
        pacienteRepository.deleteById(id);
        return "Paciente deletado " + id;
    }

    @Override
    public PacienteDTO update(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente(pacienteDTO);
        paciente = pacienteRepository.saveAndFlush(paciente);
        pacienteDTO = new PacienteDTO(paciente);
        return pacienteDTO;
    }

    @Override
    public List<PacienteDTO> getAll() {
      List<Paciente> pacienteList = pacienteRepository.findAll();
      List<PacienteDTO> pacienteDTOS = new ArrayList<>();

      for (Paciente paciente: pacienteList) {
          PacienteDTO pacienteDTO = new PacienteDTO(paciente);
          pacienteDTOS.add(pacienteDTO);
      }
        return pacienteDTOS;

    }

    public PacienteDTO getByNome(String nome) {
        Paciente paciente = pacienteRepository.findByNome(nome);
        PacienteDTO pacienteDTO = new PacienteDTO(paciente);
        return pacienteDTO;
    }
}
