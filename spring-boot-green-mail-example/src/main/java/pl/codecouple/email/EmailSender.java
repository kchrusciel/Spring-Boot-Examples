package pl.codecouple.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by CodeCouple.pl
 */
@Service
class EmailSender {

    private final JavaMailSender javaMailSender;

    EmailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    void sendEmail(String to, String from, String title, String content) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setFrom(from);
        mail.setSubject(title);
        mail.setText(content);
        javaMailSender.send(mail);
    }
}
