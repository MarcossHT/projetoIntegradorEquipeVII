package clinicaOdontologica.trabalhoIntegradorEquipeVII.repository;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
    //Hibernate
    Paciente findByNome (String nome);
}
