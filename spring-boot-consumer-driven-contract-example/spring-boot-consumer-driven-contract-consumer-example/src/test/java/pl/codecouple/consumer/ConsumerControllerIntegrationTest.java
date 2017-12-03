package pl.codecouple.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by CodeCouple.pl
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(workOffline = true, ids = { "pl.codecouple:producer-service" })
public class ConsumerControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturnUser() throws Exception {
        // When
        ResultActions result = mockMvc.perform(get("/"));
        // Then
        result.andExpect(status().isOk())
            .andExpect(content().json("{\"id\":1,\"name\":\"CodeCouple.pl\"}"));
    }

}
