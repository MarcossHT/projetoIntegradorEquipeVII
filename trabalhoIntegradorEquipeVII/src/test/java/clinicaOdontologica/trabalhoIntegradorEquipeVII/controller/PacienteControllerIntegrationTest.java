package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
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
    void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "Jason", password = "Silva123", roles = "ADMIN")
    void savePaciente() throws Exception {
        PacienteDTO pacienteDTO = new PacienteDTO();
        Endereco endereco = new Endereco(1,"Rua Rio de Janeiro", "103A", "Colina da Serra", "Jundiaí", "São Paulo");
        pacienteDTO.setId(2);
        pacienteDTO.setNome("Jason");
        pacienteDTO.setSobrenome("Albuquerque");
        pacienteDTO.setEndereco(endereco);
        pacienteDTO.setRg("45.571.765-1");
        pacienteDTO.setDataDeAlta("17/09/2022");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/pacientes/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pacienteDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);

        assertNotNull(pacienteDTO.getId());
    }

    @Test
    @WithMockUser(username = "Jason", password = "Silva123", roles = "ADMIN")
    void getById() throws Exception {
        PacienteDTO pacienteDTO = new PacienteDTO();
        Endereco endereco = new Endereco(2,"Rua Rio de Janeiro", "103A", "Colina da Serra", "Jundiaí", "São Paulo");
        pacienteDTO.setId(1);
        pacienteDTO.setNome("Fred");
        pacienteDTO.setSobrenome("Souza");
        pacienteDTO.setEndereco(endereco);
        pacienteDTO.setRg("47.871.765-1");
        pacienteDTO.setDataDeAlta("18/09/2022");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/pacientes/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pacienteDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/pacientes/{id}",pacienteDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();

        PacienteDTO pacienteDTO2 = objectFromString(PacienteDTO.class, responseBody);


        assertEquals(pacienteDTO.getId(), pacienteDTO2.getId());
        assertEquals(pacienteDTO.getNome(), pacienteDTO2.getNome());
        assertEquals(pacienteDTO.getSobrenome(), pacienteDTO2.getSobrenome());
        assertEquals(pacienteDTO.getEndereco(),pacienteDTO2.getEndereco());
        assertEquals(pacienteDTO.getRg(),pacienteDTO2.getRg());
        assertEquals(pacienteDTO.getDataDeAlta(),pacienteDTO2.getDataDeAlta());
    }
}

