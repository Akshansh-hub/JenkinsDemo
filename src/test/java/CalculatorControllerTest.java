
import com.Deploy.DeployDemo.DeployDemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest(classes = DeployDemoApplication.class)
@AutoConfigureMockMvc
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddition() throws Exception {
        mockMvc.perform(get("/calculator/add")
                        .param("a", "5")
                        .param("b", "6"))
                .andExpect(status().isOk())
                .andExpect(content().string("11"));
    }

    @Test
    void testSubtraction() throws Exception {
        mockMvc.perform(get("/calculator/subtract")
                        .param("a", "10")
                        .param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }

    @Test
    void testMultiplication() throws Exception {
        mockMvc.perform(get("/calculator/multiply")
                        .param("a", "5")
                        .param("b", "6"))
                .andExpect(status().isOk())
                .andExpect(content().string("30"));
    }

    @Test
    void testMissingParameter() throws Exception {
        mockMvc.perform(get("/calculator/add")
                        .param("a", "5"))
                .andExpect(status().isBadRequest());
    }
}
