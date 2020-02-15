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

    @Bean
    public RabbitTemplate createRabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }

    //吴涛
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

    //刘东
    /*创建 上下架交换机*/
    @Bean
    public DirectExchange createStandUpAndDown() {
        return new DirectExchange("standUp");
    }
    //创建 上下架队列
    @Bean
    public Queue createUpAndDown(){
        return  new Queue("getStandUp");
    }
    //绑定 上下架队列
    @Bean
    public Binding bindingUp(Queue createUpAndDown,DirectExchange createStandUpAndDown){
        return BindingBuilder.bind(createUpAndDown).to(createStandUpAndDown).with("getUp");
    }

    //杨彬
    //创建给前端的添加新商品交换机
    @Bean
    public DirectExchange createProductExchange(){
        return new DirectExchange("productExchange");
    }
    //创建给前端的添加新商品队列
    @Bean
    public Queue createProductQueue(){
        return new Queue("productQueue");
    }
    //绑定给前端的添加新商品交换机和队列
    @Bean
    public Binding bindingProductDirectExchange(Queue createProductQueue, DirectExchange createProductExchange){
        return BindingBuilder.bind(createProductQueue).to(createProductExchange).with("toFrontProduct");
    }
}
