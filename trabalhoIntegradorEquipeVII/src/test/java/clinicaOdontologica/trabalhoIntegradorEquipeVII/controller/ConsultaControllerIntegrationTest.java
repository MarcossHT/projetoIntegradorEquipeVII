package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Dentista;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Endereco;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.Paciente;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.ConsultaDTO;
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
    void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "Paulo", password = "Oliveira123", roles = "ADMIN")
    void saveConsulta() throws Exception {
        ConsultaDTO consultaDTO = new ConsultaDTO();
        Endereco endereco = new Endereco(1,"Rua Rio de Janeiro", "103A", "Colina da Serra", "Jundiaí", "São Paulo");
        Dentista dentista = new Dentista(1, "Paulo", "Oliveira", "55.456.987.33");
        Paciente paciente = new Paciente(1, "Jason", "Albuquerque", "17/09/2022", "45.571.765-1", endereco);
        consultaDTO.setData("18/09/2020");
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

        assertNotNull(consultaDTO.getId());
    }
}
