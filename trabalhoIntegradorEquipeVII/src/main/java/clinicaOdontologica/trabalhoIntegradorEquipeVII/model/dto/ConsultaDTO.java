package clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Consulta;

public class ConsultaDTO {
    private String data;
    private Integer idDentista;
    private Integer IdPaciente;

    public ConsultaDTO(Consulta consulta) {
        this.data = consulta.getData();
    }

    public ConsultaDTO() {
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
        return IdPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        IdPaciente = idPaciente;
    }
}
