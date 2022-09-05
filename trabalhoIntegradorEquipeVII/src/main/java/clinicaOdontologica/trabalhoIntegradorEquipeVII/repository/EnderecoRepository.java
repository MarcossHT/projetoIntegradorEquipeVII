package clinicaOdontologica.trabalhoIntegradorEquipeVII.repository;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Dentista;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EnderecoRepository {
    private static Map<Integer, Endereco> enderecoMap = new HashMap<>();

    private static Integer idEndereco = 1;

    public Endereco create(Endereco endereco) {
        endereco.setId(idEndereco++);
        enderecoMap.put(endereco.getId(), endereco);
        return endereco;
    }

    public Endereco getById(Integer id) {
        return enderecoMap.get(id);
    }

    public int getId(Integer id) {
        for (Endereco endereco: enderecoMap.values()) {
            if (id.equals(endereco.getId())) {
                return endereco.getId();
            }
        }
        return 0;
    }

    public String delete(int id) {
        enderecoMap.remove(id);
        return "Endereco deletado " + id;
    }

    public Endereco update(Endereco endereco) {
        enderecoMap.put(endereco.getId(), endereco);
        return endereco;
    }

    public List<Endereco> getAll() {
        return new ArrayList<>(enderecoMap.values());
    }
}
