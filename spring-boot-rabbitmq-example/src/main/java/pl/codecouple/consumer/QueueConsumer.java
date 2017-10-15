package pl.codecouple.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by CodeCouple.pl
 */
@Component
class QueueConsumer {

    @RabbitListener(queues = "${queue.name}")
    private void reader(String text){
        System.out.println("Consumer: " + text);
    }

}
