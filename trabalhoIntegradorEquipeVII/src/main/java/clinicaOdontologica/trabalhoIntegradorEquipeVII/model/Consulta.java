package clinicaOdontologica.trabalhoIntegradorEquipeVII.model;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.ConsultaDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name = "Consultas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "data", nullable = false)
    private String data;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Dentista.class)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "dentista_id")
    private Dentista dentista;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Paciente.class)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public Consulta() {

    }

    public Consulta(ConsultaDTO consultaDTO) {
        this.id = consultaDTO.getId();
        this.data = consultaDTO.getData();
        this.dentista = consultaDTO.getDentista();
        this.paciente = consultaDTO.getPaciente();
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
