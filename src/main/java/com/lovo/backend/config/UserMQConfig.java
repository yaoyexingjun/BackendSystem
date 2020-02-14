package com.lovo.backend.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMQConfig {
    //注入工厂
    @Autowired
    private CachingConnectionFactory connectionFactory;
    //创建点对点交换机
    @Bean
    public DirectExchange createFreezeExchange(){
        return new DirectExchange("UserFreezeDirect");
    }

    //创建冻结队列
    @Bean
    public Queue createQueueOne(){
    return  new Queue("userQueueOne");
    }
    //绑定对列
    @Bean
    public Binding bindingDirectExchange(Queue createQueueOne, DirectExchange createFreezeExchange){
        return BindingBuilder.bind(createQueueOne).to(createFreezeExchange).with("userFreezeQueue");
    }
    //创建解除冻结队列
    @Bean
    public Queue createQueueTwo(){
        return  new Queue("userQueueTwo");
    }
    //绑定对列
    @Bean
    public Binding bindingDirectExchange1(Queue createQueueTwo, DirectExchange createFreezeExchange){
        return BindingBuilder.bind(createQueueTwo).to(createFreezeExchange).with("userThawFreezeQueue");
    }

    @Bean
    public RabbitTemplate createRabbitTemplate(){

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        return rabbitTemplate;

    }

}
