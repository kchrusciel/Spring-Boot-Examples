package pl.codecouple.producer;

/**
 * Created by CodeCouple.pl
 */

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.codecouple.ProducerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
public abstract class BaseClass {

    @Autowired
    UserController userController;

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.standaloneSetup(userController);
    }

}
