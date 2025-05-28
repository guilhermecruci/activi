package sptech.school.activi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AtividadeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Quando a resposta é 4 deve retornar mensagem de acerto")
    void deveRetornarAcertoQuandoRespostaForQuatro() throws Exception {
        mockMvc.perform(get("/quiz").param("resposta", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("resposta certa")));
    }

    @Test
    @DisplayName("Quando a resposta não é 4 deve retornar mensagem de erro")
    void deveRetornarErroQuandoRespostaForDiferenteDeQuatro() throws Exception {
        mockMvc.perform(get("/quiz").param("resposta", "7"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Quase")));
    }
}

