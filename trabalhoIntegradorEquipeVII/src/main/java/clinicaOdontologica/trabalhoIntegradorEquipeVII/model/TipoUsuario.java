package clinicaOdontologica.trabalhoIntegradorEquipeVII.model;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.TipoUsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipo_usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tipo", nullable = false)
    private String tipo;

    public TipoUsuario() {
    }

    public TipoUsuario(int id, String nome) {
        this.id = id;
        this.tipo = nome;
    }

    public TipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) {
        this.id = tipoUsuarioDTO.getId();
        this.tipo = tipoUsuarioDTO.getTipo();
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
}
