package clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Consulta;

public class ConsultaDTO {

    private Integer id;
    private String data;
    private Integer idDentista;
    private Integer IdPaciente;

    public ConsultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.data = consulta.getData();
    }

    public ConsultaDTO() {
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

}
