package pl.codecouple.consumer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by CodeCouple.pl
 */
@Component
class QueueConsumer {

    @Value("${queue.name}")
    private String queueName;

    @Bean
    public Queue queue() {
        return new Queue(queueName, true, false, false, null);
    }

    @RabbitListener(queues = "${queue.name}")
    private void reader(String text){
        System.out.println("Consumer: " + text);
    }

}
