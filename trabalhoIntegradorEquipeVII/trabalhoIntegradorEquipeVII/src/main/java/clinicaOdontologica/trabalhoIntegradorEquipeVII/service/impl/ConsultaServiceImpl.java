package clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Consulta;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Dentista;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.ConsultaDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.DentistaDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.PacienteDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.repository.IConsultaRepository;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaServiceImpl implements IService<ConsultaDTO> {
    @Autowired
    private IConsultaRepository consultaRepository;

    @Autowired
    private DentistaServiceImpl dentistaService;

    @Autowired
    private PacienteServiceImpl pacienteService;

    @Override
    public ConsultaDTO create(ConsultaDTO consultaDTO) {
        Consulta consulta = new Consulta(consultaDTO);

        DentistaDTO dentistaDTO;
        int idDentista = consulta.getDentista().getId();

        PacienteDTO pacienteDTO;
        int idPaciente = consulta.getPaciente().getId();


        if(dentistaService.ifDentistaExists(idDentista) && pacienteService.ifPacienteExists(idPaciente)) {
            dentistaDTO = dentistaService.getById(idDentista);
            pacienteDTO = pacienteService.getById(idPaciente);
            Dentista dentista = new Dentista(dentistaDTO);
            Paciente paciente = new Paciente(pacienteDTO);
            consulta.setDentista(dentista);
            //consulta.setPaciente(paciente);
            consulta = consultaRepository.save(consulta);
        }

       consultaDTO = new ConsultaDTO(consulta);

        return consultaDTO;
    }

    @Override
    public ConsultaDTO getById(int id) {
        Consulta consulta = consultaRepository.findById(id).get();
        ConsultaDTO consultaDTO = new ConsultaDTO(consulta);

        return consultaDTO;
    }

    @Override
    public String delete(int id) {
        return " ";
    }

    @Override
    public ConsultaDTO update(ConsultaDTO consultaDTO, int id){
        return null;
    }

    @Override
    public List<ConsultaDTO> getAll() {

       return null;
    }
}
