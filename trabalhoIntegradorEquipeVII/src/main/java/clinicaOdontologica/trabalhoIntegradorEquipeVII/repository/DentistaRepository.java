package clinicaOdontologica.trabalhoIntegradorEquipeVII.repository;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Dentista;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DentistaRepository {
    private static Map<Integer, Dentista> dentistaMap = new HashMap<>();

    private static Integer idDentista = 1;

    public Dentista create(Dentista dentista) {
        dentista.setId(idDentista++);
        dentistaMap.put(dentista.getId(), dentista);
        return dentista;
    }

    public Dentista getByid(Integer id) {
        return dentistaMap.get(id);
    }

    public int getByName(String name) {
        for (Dentista dentista: dentistaMap.values()) {
            String dentistaName = dentista.getNome();
            if(dentistaName.equalsIgnoreCase(name))
                return dentista.getId();
        }
        return 0;
    }

    public int getId(Integer id) {
        for (Dentista dentista: dentistaMap.values()) {
            if (id.equals(dentista.getId())) {
                return dentista.getId();
            }
        }
        return 0;
    }

    public String delete(int id) {
        dentistaMap.remove(id);
        return "Dentista deletado " + id;
    }

    public Dentista update(Dentista dentista) {
        dentistaMap.put(dentista.getId(), dentista);
        return dentista;
    }

    public List<Dentista> getAll() {
        return new ArrayList<>(dentistaMap.values());
    }
}
