package clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;

public class PacienteDTO {

    private int id;
    private String nome;
    private String sobrenome;


    private Endereco endereco;
    private String rg;
    private String dataDeAlta;


    public PacienteDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.endereco = paciente.getEndereco();
        this.rg = paciente.getRg();
        this.dataDeAlta = paciente.getDataDeAlta();
    }

    public PacienteDTO() {
    }

    public PacienteDTO(int id, String nome, String sobrenome, Endereco endereco, String rg, String dataDeAlta) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.rg = rg;
        this.dataDeAlta = dataDeAlta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setDataDeAlta(String dataDeAlta) {
        this.dataDeAlta = dataDeAlta;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getRg() {
        return rg;
    }


    public String getDataDeAlta() {
        return dataDeAlta;
    }

}
