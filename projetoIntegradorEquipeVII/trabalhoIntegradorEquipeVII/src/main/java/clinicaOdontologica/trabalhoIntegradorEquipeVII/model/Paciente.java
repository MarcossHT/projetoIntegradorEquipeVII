package clinicaOdontologica.trabalhoIntegradorEquipeVII.model;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.PacienteDTO;

public class Paciente {
    private Integer id;
    private String nome;
    private String sobrenome;
    private Integer idEndereco;
    private String rg;
    private String dataDeAlta;

    public Paciente(Integer id, String nome, String sobrenome, Integer idEndereco, String rg, String dataDeAlta) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idEndereco = idEndereco;
        this.rg = rg;
        this.dataDeAlta = dataDeAlta;
    }

    public Paciente(String nome, String sobrenome, String rg, String dataDeAlta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.dataDeAlta = dataDeAlta;
    }

    public Paciente(PacienteDTO pacienteDTO) {
        this.nome = pacienteDTO.getNome();
        this.sobrenome = pacienteDTO.getSobrenome();
        this.rg = pacienteDTO.getRg();
        this.dataDeAlta = pacienteDTO.getDataDeAlta();
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

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataDeAlta() {
        return dataDeAlta;
    }

    public void setDataDeAlta(String dataDeAlta) {
        this.dataDeAlta = dataDeAlta;
    }
}
