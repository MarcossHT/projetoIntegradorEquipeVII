package clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Dentista;

public class DentistaDTO {
    private String nome;
    private String sobrenome;
    private String matriculaCadastro;


    public DentistaDTO(Dentista dentista) {
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
        this.matriculaCadastro = dentista.getMatriculaCadastro();
    }

    public DentistaDTO() {
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

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMatriculaCadastro() {
        return matriculaCadastro;
    }

    public void setMatriculaCadastro(String matriculaCadastro) {
        this.matriculaCadastro = matriculaCadastro;
    }
}
