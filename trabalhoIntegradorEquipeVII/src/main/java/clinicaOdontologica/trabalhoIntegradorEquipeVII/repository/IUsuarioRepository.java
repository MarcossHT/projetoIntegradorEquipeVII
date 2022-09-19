package clinicaOdontologica.trabalhoIntegradorEquipeVII.repository;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNome(String nome);
}
