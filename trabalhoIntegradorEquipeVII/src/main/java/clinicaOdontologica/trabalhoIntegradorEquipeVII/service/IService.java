package clinicaOdontologica.trabalhoIntegradorEquipeVII.service;

import java.util.List;

public interface IService<T> {
    T create(T t);
    T getById(int id);

    String delete(int id);

    T update(T t);

    List<T> getAll();
}
