package clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Consulta;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Dentista;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;

public class ConsultaDTO {

    private int id;
    private String data;

    private Dentista dentista;

    private Paciente paciente;


    public ConsultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.data = consulta.getData();
        this.dentista = consulta.getDentista();
        this.paciente = consulta.getPaciente();
    }

    public ConsultaDTO() {
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
}
