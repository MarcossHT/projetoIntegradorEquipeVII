package clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Dentista;


public class DentistaDTO {

    private int id;
    private String nome;
    private String sobrenome;
    private String matriculaCadastro;

    public DentistaDTO() {
    }
    public DentistaDTO(Dentista dentista) {
        this.id = dentista.getId();
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
        this.matriculaCadastro = dentista.getMatriculaCadastro();
    }

    public DentistaDTO(int id, String nome, String sobrenome, String matriculaCadastro) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matriculaCadastro = matriculaCadastro;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setMatriculaCadastro(String matriculaCadastro) {
        this.matriculaCadastro = matriculaCadastro;
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

}
