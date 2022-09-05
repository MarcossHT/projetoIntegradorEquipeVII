package clinicaOdontologica.trabalhoIntegradorEquipeVII.repository;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Consulta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ConsultaRepository {
    private static Map<Integer, Consulta> consultaMap = new HashMap<>();

    private static Integer idConsulta = 1;

    public Consulta create(Consulta consulta) {
        consulta.setId(idConsulta++);
        consultaMap.put(consulta.getId(), consulta);
        return consulta;
    }

    public Consulta getById(int id) {
        return consultaMap.get(id);
    }

    public String delete(int id) {
        consultaMap.remove(id);
        return "Consulta deletada " + id;
    }

    public Consulta update(Consulta consulta) {
        consultaMap.put(consulta.getId(), consulta);
        return consulta;
    }

    public List<Consulta> getAll() {
        return new ArrayList<>(consultaMap.values());
    }
}
