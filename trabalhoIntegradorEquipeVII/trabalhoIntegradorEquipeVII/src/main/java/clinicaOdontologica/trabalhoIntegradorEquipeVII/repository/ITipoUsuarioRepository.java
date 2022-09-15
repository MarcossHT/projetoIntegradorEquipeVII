package clinicaOdontologica.trabalhoIntegradorEquipeVII.repository;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
}
