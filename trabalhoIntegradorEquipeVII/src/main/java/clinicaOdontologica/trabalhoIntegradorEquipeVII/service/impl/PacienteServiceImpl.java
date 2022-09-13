package clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.EnderecoDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.PacienteDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.repository.IPacienteRepository;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements IService<PacienteDTO> {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private EnderecoServiceImpl enderecoService;

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

    @Override
    public String delete(int id) {
        /*return pacienteRepository.delete(id);*/
        return null;
    }


    @Override
    public PacienteDTO update(PacienteDTO pacienteDTO, int id) {
        /*Paciente paciente = new Paciente(pacienteDTO);
        int enderecoIdPaciente = pacienteDTO.getIdEndereco();
        int enderecoId = enderecoService.getIdEndereco(enderecoIdPaciente);
        paciente.setIdEndereco(enderecoId);
        paciente.setId(id);

        if(paciente.getIdEndereco() != 0)
            pacienteRepository.create(paciente);
        return pacienteDTO;*/
        return null;
    }

    @Override
    public List<PacienteDTO> getAll() {
        /*List<Paciente> pacienteList = pacienteRepository.getAll();
        List<PacienteDTO> pacienteDTOS = new ArrayList<>();

        for(Paciente paciente: pacienteList){
            int enderecoIdPaciente = getEnderecoId(paciente);
            PacienteDTO pacienteDTO = new PacienteDTO(paciente);
            pacienteDTO.setIdEndereco(enderecoIdPaciente);
            pacienteDTOS.add(pacienteDTO);
        }
        return pacienteDTOS;*/
        return null;
    }

    public boolean ifPacienteExists(int id) {
        return pacienteRepository.existsById(id);
    }
}
