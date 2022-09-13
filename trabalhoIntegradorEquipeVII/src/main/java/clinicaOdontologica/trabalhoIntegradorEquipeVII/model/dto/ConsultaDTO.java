package clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Consulta;

public class ConsultaDTO {
    private Integer id;
    private String data;
    private Integer idDentista;

    private Integer idPaciente;

    public ConsultaDTO() {
    }

    public ConsultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.data = consulta.getData();
    }

    public Integer getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(Integer idDentista) {
        this.idDentista = idDentista;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }
}
