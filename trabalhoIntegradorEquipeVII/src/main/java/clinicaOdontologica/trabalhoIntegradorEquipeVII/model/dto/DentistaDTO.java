package clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Dentista;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Usuario;

public class DentistaDTO {

    private int id;
    private String nome;
    private String sobrenome;
    private String matriculaCadastro;

    private Usuario usuario;

    public DentistaDTO() {
    }
    public DentistaDTO(Dentista dentista) {
        this.id = dentista.getId();
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
        this.matriculaCadastro = dentista.getMatriculaCadastro();
        this.usuario = dentista.getUsuario();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public String getMatriculaCadastro() {
        return matriculaCadastro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
