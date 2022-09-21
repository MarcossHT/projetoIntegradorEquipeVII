package clinicaOdontologica.trabalhoIntegradorEquipeVII.repository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
    Usuario fingByNome(String nome);
}
