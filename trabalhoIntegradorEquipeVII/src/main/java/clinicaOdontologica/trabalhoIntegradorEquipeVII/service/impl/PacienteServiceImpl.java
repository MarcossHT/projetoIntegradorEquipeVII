package clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.IService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PacienteServiceImpl implements IService<Paciente> {

    private static Map<Integer, Paciente> pacienteMap = new HashMap<>();

    @Override
    public Paciente salvar(Paciente paciente) {
        pacienteMap.put(paciente.getId(), paciente);
        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() {
        return new ArrayList<>(pacienteMap.values());
    }

    @Override
    public String excluir(Integer id) {
        pacienteMap.remove(id);
        return "Paciente removido " + id;
    }
}
