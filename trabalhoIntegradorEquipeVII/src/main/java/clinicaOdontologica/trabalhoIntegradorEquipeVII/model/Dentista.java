package clinicaOdontologica.trabalhoIntegradorEquipeVII.model;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.DentistaDTO;

public class Dentista {
    private Integer id;
    private String nome;

    private String sobrenome;
    private String matriculaCadastro;

    public Dentista(Integer id, String nome, String sobrenome, String matriculaCadastro) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matriculaCadastro = matriculaCadastro;
    }

    public Dentista(String nome, String sobrenome, String matriculaCadastro) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matriculaCadastro = matriculaCadastro;
    }

    public Dentista(DentistaDTO dentistaDTO) {
        this.nome = dentistaDTO.getNome();
        this.sobrenome = dentistaDTO.getSobrenome();
        this.matriculaCadastro = dentistaDTO.getMatriculaCadastro();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
