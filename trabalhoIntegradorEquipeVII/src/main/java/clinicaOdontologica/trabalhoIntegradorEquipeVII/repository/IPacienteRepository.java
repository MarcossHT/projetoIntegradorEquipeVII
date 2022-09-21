package clinicaOdontologica.trabalhoIntegradorEquipeVII.repository;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer>{
    Paciente findByNome(String nome);
}
