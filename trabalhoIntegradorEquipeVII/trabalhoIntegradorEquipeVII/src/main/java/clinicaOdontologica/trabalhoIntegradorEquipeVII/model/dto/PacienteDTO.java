package clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Usuario;

public class PacienteDTO {

    private int id;
    private String nome;
    private String sobrenome;

    private Usuario usuario;
    private Endereco endereco;
    private String rg;
    private String dataDeAlta;


    public PacienteDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.usuario = paciente.getUsuario();
        this.endereco = paciente.getEndereco();
        this.rg = paciente.getRg();
        this.dataDeAlta = paciente.getDataDeAlta();
    }

    public PacienteDTO() {
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Usuario getUsuario() {
        return usuario;
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
