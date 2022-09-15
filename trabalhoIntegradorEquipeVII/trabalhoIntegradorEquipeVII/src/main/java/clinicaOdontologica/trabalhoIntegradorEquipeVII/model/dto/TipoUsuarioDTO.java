package clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.TipoUsuario;

public class TipoUsuarioDTO {
    private int id;

    private String tipo;

    public TipoUsuarioDTO() {
    }

    public TipoUsuarioDTO(TipoUsuario usuario) {
        this.id = usuario.getId();
        this.tipo = usuario.getTipo();
    }

    public int getId() {
        return id;
    }


    public String getTipo() {
        return tipo;
    }
}
