package pl.codecouple.email;

import com.icegreen.greenmail.junit.GreenMailRule;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by CodeCouple.pl
 */
@SpringBootTest
@ActiveProfiles("email")
@RunWith(SpringRunner.class)
public class EmailSenderTest {

    @Rule
    public GreenMailRule server = new GreenMailRule(new ServerSetup(25, "localhost", "smtp"));

    @Autowired
    EmailSender emailSender;


    @Test
    public void shouldSendEmail() throws Exception {
        // Given
        String to = "test@codecouple.pl";
        String from = "blog@codecouple.pl";
        String title = "Title";
        String content = "Content";
        // When
        emailSender.sendEmail(to, from, title, content);
        // Then
        MimeMessage[] receivedMessages = server.getReceivedMessages();
        assertThat(receivedMessages.length).isEqualTo(1);

        MimeMessage receivedMessage = receivedMessages[0];
        assertThat(receivedMessage.getAllRecipients()[0].toString()).isEqualTo(to); //to
        assertThat(receivedMessage.getFrom()[0].toString()).isEqualTo(from); //from
        assertThat(receivedMessage.getSubject()).isEqualTo(title); //title
        assertThat(receivedMessage.getContent().toString()).contains(content); //content
        //Or
        assertThat(content).isEqualTo(GreenMailUtil.getBody(server.getReceivedMessages()[0]));
    }

}