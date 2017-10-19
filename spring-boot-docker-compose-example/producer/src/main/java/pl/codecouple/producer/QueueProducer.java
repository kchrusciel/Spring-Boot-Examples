package pl.codecouple.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CodeCouple.pl
 */
@RestController("/queue")
class QueueProducer {

    @Value("${queue.name}")
    private String queueName;

    @Autowired
    RabbitTemplate queueSender;

    @GetMapping
    String sendToQueue(@RequestParam(value = "message", defaultValue = "CodeCouple.pl") String message){
        queueSender.convertAndSend(queueName, message);
        return String.format("Message %s sent! See logs...", message);
    }

}
