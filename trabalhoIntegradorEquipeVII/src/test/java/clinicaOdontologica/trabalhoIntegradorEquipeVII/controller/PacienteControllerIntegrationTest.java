package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
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
class PacienteControllerIntegrationTest {

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
    @WithMockUser(username = "TesteEndereco", password = "1234", roles = "ADMIN")
    void createEndereco() throws Exception {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setRua("Rua do teste 1");
        enderecoDTO.setBairro("Bairro do teste 1");
        enderecoDTO.setEstado("Estado do teste 1");
        enderecoDTO.setNumero("123");
        enderecoDTO.setCidade("cidade do teste 1");

        mockMvc.perform(MockMvcRequestBuilders.post("/enderecos/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(enderecoDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }


    @Test
    @WithMockUser(username = "TestePaciente", password = "1234", roles = "ADMIN")
    void create() throws Exception {
        Endereco endereco = new Endereco(new EnderecoDTO(1, "rua do teste", "123",
                "bairro do teste", "cidade do teste", "estado do teste"));
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNome("PacienteTeste1");
        pacienteDTO.setRg("12345");
        pacienteDTO.setSobrenome("Teste1");
        pacienteDTO.setDataDeAlta("27/09/2022");
        pacienteDTO.setEndereco(endereco);

        mockMvc.perform(MockMvcRequestBuilders.post("/pacientes/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pacienteDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    @WithMockUser(username = "TestePaciente", password = "1234", roles = "ADMIN")
    void findById() throws Exception {
        Endereco endereco = new Endereco(new EnderecoDTO(1, "rua do teste", "123",
                "bairro do teste", "cidade do teste", "estado do teste"));
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNome("PacienteTeste1");
        pacienteDTO.setRg("12345");
        pacienteDTO.setSobrenome("Teste1");
        pacienteDTO.setDataDeAlta("27/09/2022");
        pacienteDTO.setEndereco(endereco);
        pacienteDTO.setId(2);


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/pacientes/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pacienteDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/pacientes/{id}", pacienteDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();

        PacienteDTO pacienteDTO1 = objectFromString(PacienteDTO.class, responseBody);

        assertEquals(pacienteDTO.getId(), pacienteDTO1.getId());
        assertEquals(pacienteDTO.getNome(), pacienteDTO1.getNome());
    }

    @Test
    @WithMockUser(username = "TestePaciente", password = "1234", roles = "ADMIN")
    void delete() throws Exception {
        Endereco endereco = new Endereco(new EnderecoDTO(1, "rua do teste", "123",
                "bairro do teste", "cidade do teste", "estado do teste"));
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNome("PacienteTeste1");
        pacienteDTO.setRg("12345");
        pacienteDTO.setSobrenome("Teste1");
        pacienteDTO.setDataDeAlta("27/09/2022");
        pacienteDTO.setEndereco(endereco);
        pacienteDTO.setId(1);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/pacientes/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pacienteDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);

        mockMvc.perform(MockMvcRequestBuilders.delete("/pacientes/deletar/{id}", pacienteDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}