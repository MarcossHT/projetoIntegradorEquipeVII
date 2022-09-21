package clinicaOdontologica.trabalhoIntegradorEquipeVII.repository;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Dentista;

public interface IDentistaRepository extends JpaRepository<Dentista, Integer>{
    Dentista findByNome(String nome);
}
