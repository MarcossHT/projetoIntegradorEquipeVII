package clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Consulta;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.ConsultaDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.PacienteDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.repository.ConsultaRepository;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.repository.DentistaRepository;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.repository.PacienteRepository;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaServiceImpl implements IService<ConsultaDTO> {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private DentistaServiceImpl dentistaService;

    @Autowired
    private PacienteServiceImpl pacienteService;

    @Override
    public ConsultaDTO create(ConsultaDTO consultaDTO) {
        Consulta consulta = new Consulta(consultaDTO);

        int idDentista = consultaDTO.getIdDentista();
        int idPaciente = consultaDTO.getIdPaciente();

        int dentistaStoredId = dentistaService.getIdDentista(idDentista);
        int pacienteStoredId = pacienteService.getIdPaciente(idPaciente);

        consulta.setIdDentista(dentistaStoredId);
        consulta.setIdPaciente(pacienteStoredId);

        if(consulta.getIdDentista() != 0 && consulta.getIdPaciente() != 0) {
            consultaRepository.create(consulta);
        }

        return consultaDTO;
    }

    @Override
    public ConsultaDTO getById(int id) {
        Consulta consulta = consultaRepository.getById(id);
        ConsultaDTO consultaDTO = new ConsultaDTO(consulta);

        int dentistaId = getDentistaId(consulta);
        int pacienteId = getPacienteId(consulta);
        consultaDTO.setIdDentista(dentistaId);
        consultaDTO.setIdPaciente(pacienteId);

        return consultaDTO;

    }

    private int getDentistaId(Consulta consulta) {
        int dentistaIdConsulta = consulta.getIdDentista();
        int dentistaId = dentistaService.getIdDentista(dentistaIdConsulta);
        return dentistaId;
    }

    private int getPacienteId(Consulta consulta) {
        int pacienteIdPaciente = consulta.getIdPaciente();
        int enderecoId = pacienteService.getIdPaciente(pacienteIdPaciente);
        return enderecoId;
    }

    @Override
    public String delete(int id) {
        return consultaRepository.delete(id);
    }

    @Override
    public ConsultaDTO update(ConsultaDTO consultaDTO, int id) {
        Consulta consulta = new Consulta(consultaDTO);
        int dentistaIdDTO = consultaDTO.getIdDentista();
        int dentistaId = dentistaService.getIdDentista(dentistaIdDTO);
        consulta.setIdDentista(dentistaId);

        int pacienteDTO = consultaDTO.getIdPaciente();
        int pacienteId = pacienteService.getIdPaciente(pacienteDTO);
        consulta.setIdPaciente(pacienteId);

        consulta.setId(id);

        if(consulta.getIdDentista() != 0 && consulta.getIdPaciente() != 0)
            consultaRepository.create(consulta);
        return consultaDTO;
    }

    @Override
    public List<ConsultaDTO> getAll() {
        List<Consulta> consultaList = consultaRepository.getAll();
        List<ConsultaDTO> consultaDTOS = new ArrayList<>();

        for(Consulta consulta: consultaList){
            int dentistaIdConsulta = getDentistaId(consulta);
            int pacienteIdConsulta = getPacienteId(consulta);
            ConsultaDTO consultaDTO = new ConsultaDTO(consulta);
            consultaDTO.setIdDentista(dentistaIdConsulta);
            consultaDTO.setIdPaciente(pacienteIdConsulta);
            consultaDTOS.add(consultaDTO);
        }
        return consultaDTOS;
    }
}
