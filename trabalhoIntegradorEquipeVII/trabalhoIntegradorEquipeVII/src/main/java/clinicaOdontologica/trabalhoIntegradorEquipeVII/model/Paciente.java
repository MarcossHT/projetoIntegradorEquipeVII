package clinicaOdontologica.trabalhoIntegradorEquipeVII.model;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.PacienteDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Pacientes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;
    @Column(name = "rg", unique = true, nullable = false)
    private String rg;
    @Column(name = "dataDeAlta", nullable = false)
    private String dataDeAlta;

    /*@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Usuario.class)
    private Usuario usuario;*/
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Endereco.class)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;


    /*@OneToOne(mappedBy = "paciente", fetch = FetchType.LAZY, targetEntity = Consulta.class)
    @JsonIgnore
    private List<Consulta> consultaList = new ArrayList<>();*/

    public Paciente() {

    }

    public Paciente(PacienteDTO pacienteDTO) {
        this.id = pacienteDTO.getId();
        this.nome = pacienteDTO.getNome();
        this.sobrenome = pacienteDTO.getSobrenome();
        this.endereco = pacienteDTO.getEndereco();
        this.rg = pacienteDTO.getRg();
        this.dataDeAlta = pacienteDTO.getDataDeAlta();
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

    public String getRg() {
        return rg;
    }

    public String getDataDeAlta() {
        return dataDeAlta;
    }

    /*public Usuario getUsuario() {
        return usuario;
    }

    public List<Consulta> getConsultaList() {
        return consultaList;
    }*/

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /*public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }*/
}
