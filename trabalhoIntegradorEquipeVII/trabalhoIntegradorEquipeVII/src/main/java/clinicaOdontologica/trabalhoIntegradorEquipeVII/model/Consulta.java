package clinicaOdontologica.trabalhoIntegradorEquipeVII.model;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.ConsultaDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Consultoria")
@JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})

public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(name = "data", nullable = false)
    private String data;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "dentista_id")
    private Dentista dentista;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Integer paciente;

    public Consulta() {

    }
    public Consulta(ConsultaDTO consultaDTO) {
        this.id = consultaDTO.getId();
        this.data = consultaDTO.getData();
    }
    public Dentista getDentista() {
        return dentista;
    }
    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Paciente getPaciente(){
        return paciente;
    }

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    }
    public String getData(){
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

}
