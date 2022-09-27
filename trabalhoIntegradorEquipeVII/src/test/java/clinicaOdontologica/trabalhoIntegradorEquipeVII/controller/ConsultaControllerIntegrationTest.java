package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Dentista;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.ConsultaDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.DentistaDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.EnderecoDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.PacienteDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static clinicaOdontologica.trabalhoIntegradorEquipeVII.utils.TrabalhoIntegradorUtils.asJsonString;
import static clinicaOdontologica.trabalhoIntegradorEquipeVII.utils.TrabalhoIntegradorUtils.objectFromString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
@AutoConfigureMockMvc
class ConsultaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "TesteConsulta", password = "1234", roles = "ADMIN")
    void create() throws Exception {
        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome("Teste1");
        dentistaDTO.setSobrenome("DentistaTeste1");
        dentistaDTO.setMatriculaCadastro("123Dentista1");
        dentistaDTO.setId(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/dentistas/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dentistaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setRua("Rua do teste 1");
        enderecoDTO.setBairro("Bairro do teste 1");
        enderecoDTO.setEstado("Estado do teste 1");
        enderecoDTO.setNumero("123");
        enderecoDTO.setCidade("cidade do teste 1");
        enderecoDTO.setId(1);


        mockMvc.perform(MockMvcRequestBuilders.post("/enderecos/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(enderecoDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNome("PacienteTeste1");
        pacienteDTO.setRg("12345");
        pacienteDTO.setSobrenome("Teste1");
        pacienteDTO.setDataDeAlta("27/09/2022");
        pacienteDTO.setEndereco(new Endereco(enderecoDTO));
        pacienteDTO.setId(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/pacientes/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pacienteDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();


        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setData("27/09/2022");
        consultaDTO.setDentista(new Dentista(dentistaDTO));
        consultaDTO.setPaciente(new Paciente(pacienteDTO));

        mockMvc.perform(MockMvcRequestBuilders.post("/consultas/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(consultaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    @WithMockUser(username = "TesteConsulta", password = "1234", roles = "ADMIN")
    void findById() throws Exception {
        Dentista dentista = new Dentista(new DentistaDTO(1, "Dentistateste1", "Teste",
                "123teste"));

        Endereco endereco = new Endereco(new EnderecoDTO(1, "rua do teste", "123",
                "bairro do teste", "cidade do teste", "estado do teste"));

        Paciente paciente = new Paciente(new PacienteDTO(1, "PacienteTeste", "Teste", endereco,
                "123Teste", "27/09/2022"));

        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setId(2);
        consultaDTO.setData("27/09/2022");
        consultaDTO.setDentista(dentista);
        consultaDTO.setPaciente(paciente);


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/consultas/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(consultaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/consultas/{id}", consultaDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();

        ConsultaDTO consultaDTO1 = objectFromString(ConsultaDTO.class, responseBody);

        assertEquals(consultaDTO.getId(), consultaDTO1.getId());
        assertEquals(consultaDTO.getData(), consultaDTO1.getData());
    }

    @Test
    @WithMockUser(username = "TesteConsulta", password = "1234", roles = "ADMIN")
    void delete() throws Exception {
        Endereco endereco = new Endereco(new EnderecoDTO(1, "rua do teste", "123",
                "bairro do teste", "cidade do teste", "estado do teste"));

        Paciente paciente = new Paciente(new PacienteDTO(1, "PacienteTeste", "Teste", endereco,
                "123Teste", "27/09/2022"));

        Dentista dentista = new Dentista(new DentistaDTO(1, "Dentistateste1", "Teste",
                "123teste"));

        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setId(1);
        consultaDTO.setData("27/09/2022");
        consultaDTO.setDentista(dentista);
        consultaDTO.setPaciente(paciente);


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/consultas/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(consultaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        consultaDTO = objectFromString(ConsultaDTO.class, responseBody);

        mockMvc.perform(MockMvcRequestBuilders.delete("/consultas/deletar/{id}", consultaDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}