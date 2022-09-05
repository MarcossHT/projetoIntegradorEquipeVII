package clinicaOdontologica.trabalhoIntegradorEquipeVII.repository;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Dentista;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class PacienteRepository {
    private static Map<Integer, Paciente> pacienteMap = new HashMap<>();

    private static Integer idPaciente = 1;

    public Paciente create(Paciente paciente) {
        paciente.setId(idPaciente++);
        pacienteMap.put(paciente.getId(), paciente);
        return paciente;
    }

    public Paciente getById(Integer id) {
        return pacienteMap.get(id);
    }

    public int getByName(String name) {
        for (Paciente paciente: pacienteMap.values()) {
            String pacienteName = paciente.getNome();
            if (pacienteName.equalsIgnoreCase(name))
                return paciente.getId();
        }
        return 0;
    }

    public int getId(Integer id) {
        for (Paciente paciente: pacienteMap.values()) {
            if (id.equals(paciente.getId())) {
                return paciente.getId();
            }
        }
        return 0;
    }

    public String delete(int id) {
        pacienteMap.remove(id);
        return "Paciente deletado " + id;
    }

    public Paciente update(Paciente paciente) {
        pacienteMap.put(paciente.getId(), paciente);
        return paciente;
    }

    public List<Paciente> getAll() {
        return new ArrayList<>(pacienteMap.values());
    }
}
