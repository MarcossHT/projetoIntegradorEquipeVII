package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.DentistaDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.utils.TrabalhoIntegradorUtils;
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
class DentistaControllerIntegrationTest {
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
    @WithMockUser(username = "TesteDentista", password = "1234", roles = "ADMIN")
    void create() throws Exception {
        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome("Teste1");
        dentistaDTO.setSobrenome("DentistaTeste1");
        dentistaDTO.setMatriculaCadastro("123Dentista1");

        mockMvc.perform(MockMvcRequestBuilders.post("/dentistas/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dentistaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    @WithMockUser(username = "TesteDentista", password = "1234", roles = "ADMIN")
    void findById() throws Exception {
        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome("Teste1");
        dentistaDTO.setSobrenome("DentistaTeste1");
        dentistaDTO.setMatriculaCadastro("123Dentista1");
        dentistaDTO.setId(2);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/dentistas/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dentistaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/dentistas/{id}", dentistaDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();

        DentistaDTO dentistaDTO1 = objectFromString(DentistaDTO.class, responseBody);

        assertEquals(dentistaDTO.getId(), dentistaDTO1.getId());
        assertEquals(dentistaDTO.getNome(), dentistaDTO1.getNome());
    }

    @Test
    @WithMockUser(username = "TesteDentista", password = "1234", roles = "ADMIN")
    void delete() throws Exception {
        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome("Teste1");
        dentistaDTO.setSobrenome("DentistaTeste1");
        dentistaDTO.setMatriculaCadastro("123Dentista1");
        dentistaDTO.setId(1);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/dentistas/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dentistaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        dentistaDTO = objectFromString(DentistaDTO.class, responseBody);

        mockMvc.perform(MockMvcRequestBuilders.delete("/dentistas/deletar/{id}", dentistaDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}