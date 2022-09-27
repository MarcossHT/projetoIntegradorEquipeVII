package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;

import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.DentistaDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.EnderecoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
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
class EnderecoControllerIntegrationTest {

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
    void create() throws Exception {
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
    @WithMockUser(username = "TesteEndereco", password = "1234", roles = "ADMIN")
    void findById() throws Exception {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setRua("Rua do teste 1");
        enderecoDTO.setBairro("Bairro do teste 1");
        enderecoDTO.setEstado("Estado do teste 1");
        enderecoDTO.setNumero("123");
        enderecoDTO.setCidade("cidade do teste 1");
        enderecoDTO.setId(1);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/enderecos/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(enderecoDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/enderecos/{id}", enderecoDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();

        EnderecoDTO enderecoDTO1 = objectFromString(EnderecoDTO.class, responseBody);

        assertEquals(enderecoDTO.getId(), enderecoDTO1.getId());
        assertEquals(enderecoDTO.getRua(), enderecoDTO1.getRua());
    }

    @Test
    @WithMockUser(username = "TesteEndereco", password = "1234", roles = "ADMIN")
    void delete() throws Exception {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setRua("Rua do teste 1");
        enderecoDTO.setBairro("Bairro do teste 1");
        enderecoDTO.setEstado("Estado do teste 1");
        enderecoDTO.setNumero("123");
        enderecoDTO.setCidade("cidade do teste 1");
        enderecoDTO.setId(2);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/enderecos/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(enderecoDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        enderecoDTO = objectFromString(EnderecoDTO.class, responseBody);

        mockMvc.perform(MockMvcRequestBuilders.delete("/enderecos/deletar/{id}", enderecoDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}