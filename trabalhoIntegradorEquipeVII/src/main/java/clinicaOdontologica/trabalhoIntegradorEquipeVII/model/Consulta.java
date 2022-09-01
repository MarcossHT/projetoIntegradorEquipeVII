package clinicaOdontologica.trabalhoIntegradorEquipeVII.model;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.ConsultaDTO;

public class Consulta {
    private Integer id;
    private String data;
    private Integer idDentista;
    private Integer IdPaciente;

    public Consulta(String data, Integer idDentista, Integer idPaciente) {
        this.data = data;
        this.idDentista = idDentista;
        IdPaciente = idPaciente;
    }

    public Consulta(ConsultaDTO consultaDTO) {
        this.data = consultaDTO.getData();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
