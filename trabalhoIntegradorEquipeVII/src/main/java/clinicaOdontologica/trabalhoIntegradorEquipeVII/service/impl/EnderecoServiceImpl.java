package clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.IService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EnderecoServiceImpl implements IService<Endereco> {

    private static Map<Integer, Endereco> enderecoMap = new HashMap<>();

    @Override
    public Endereco salvar(Endereco endereco) {
        enderecoMap.put(endereco.getId(), endereco);
        return endereco;
    }

    @Override
    public List<Endereco> buscarTodos() {
        return new ArrayList<>(enderecoMap.values());
    }

    @Override
    public String excluir(Integer id) {
        enderecoMap.remove(id);
        return "Endereco removido " + id;
    }
}
