package clinicaOdontologica.trabalhoIntegradorEquipeVII.model;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.DentistaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Dentistas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dentista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;
    @Column(name = "matriculaCadastro", unique = true, nullable = false)
    private String matriculaCadastro;
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Usuario.class)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    /*@OneToOne(mappedBy = "dentista", fetch = FetchType.LAZY, targetEntity = Consulta.class)
    @JsonIgnore
    private List<Consulta> consultaList = new ArrayList<>();*/



    public Dentista() {

    }

    public Dentista(DentistaDTO dentistaDTO) {
        this.id = dentistaDTO.getId();
        this.nome = dentistaDTO.getNome();
        this.sobrenome = dentistaDTO.getSobrenome();
        this.matriculaCadastro = dentistaDTO.getMatriculaCadastro();
        this.usuario = dentistaDTO.getUsuario();
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

    /*public List<Consulta> getConsultaList() {
        return consultaList;
    }*/

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
