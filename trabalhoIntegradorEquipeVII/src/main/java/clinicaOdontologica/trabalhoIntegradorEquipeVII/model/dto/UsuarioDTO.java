package clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.TipoUsuario;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Usuario;

public class UsuarioDTO {
    private int id;

    private String nome;

    private String email;

    private String senha;

    private TipoUsuario tipoUsuario;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.tipoUsuario = usuario.getTipoUsuario();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
}
