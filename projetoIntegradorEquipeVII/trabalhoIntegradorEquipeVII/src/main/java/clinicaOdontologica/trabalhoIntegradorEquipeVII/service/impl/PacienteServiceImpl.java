package clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.EnderecoDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.PacienteDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.repository.PacienteRepository;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PacienteServiceImpl implements IService<PacienteDTO> {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @Override
    public PacienteDTO create(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente(pacienteDTO);
        int idEnderecoDTO = pacienteDTO.getIdEndereco();
        int enderecoStoredId = enderecoService.getIdEndereco(idEnderecoDTO);

        paciente.setIdEndereco(enderecoStoredId);

        if (paciente.getIdEndereco() != 0) {
            pacienteRepository.create(paciente);
        }

        return pacienteDTO;
    }

    @Override
    public PacienteDTO getById(int id) {
        Paciente paciente = pacienteRepository.getById(id);
        PacienteDTO pacienteDTO = new PacienteDTO(paciente);

        int enderecoId = getEnderecoId(paciente);
        pacienteDTO.setIdEndereco(enderecoId);

        return pacienteDTO;
    }

    private int getEnderecoId(Paciente paciente) {
        int enderecoIdPaciente = paciente.getIdEndereco();
        int enderecoId = enderecoService.getIdEndereco(enderecoIdPaciente);
        return enderecoId;
    }

    public int getIdPaciente(int id) {
        return pacienteRepository.getId(id);
    }


    @Override
    public String delete(int id) {
        return pacienteRepository.delete(id);
    }


    @Override
    public PacienteDTO update(PacienteDTO pacienteDTO, int id) {
        Paciente paciente = new Paciente(pacienteDTO);
        int enderecoIdPaciente = pacienteDTO.getIdEndereco();
        int enderecoId = enderecoService.getIdEndereco(enderecoIdPaciente);
        paciente.setIdEndereco(enderecoId);
        paciente.setId(id);

        if(paciente.getIdEndereco() != 0)
            pacienteRepository.create(paciente);
        return pacienteDTO;
    }

    @Override
    public List<PacienteDTO> getAll() {
        List<Paciente> pacienteList = pacienteRepository.getAll();
        List<PacienteDTO> pacienteDTOS = new ArrayList<>();

        for(Paciente paciente: pacienteList){
            int enderecoIdPaciente = getEnderecoId(paciente);
            PacienteDTO pacienteDTO = new PacienteDTO(paciente);
            pacienteDTO.setIdEndereco(enderecoIdPaciente);
            pacienteDTOS.add(pacienteDTO);
        }
        return pacienteDTOS;

    }
}
