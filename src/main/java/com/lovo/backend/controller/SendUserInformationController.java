package com.lovo.backend.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送用户相应操作消息到对列
 * 吴涛
 */
@RestController
public class SendUserInformationController {
    //注入MQ模板
    @Autowired
    private RabbitTemplate rabbitTemplate;
    //向对列中发送冻结消息
    @RequestMapping("sendUserFreezeInformation")
    public void sendUserFreezeInformation(String userId,String causerFreeze){
        String information = null;
        information = userId+","+causerFreeze;
        //ObjectMapper objectMapper = new ObjectMapper();
        rabbitTemplate.convertAndSend("UserFreezeDirect","userFreezeQueue",information);
    }
    //向对列中发送解除冻结消息
    @RequestMapping("sendUserThawFreezeInformation")
    public void sendUserThawFreezeInformation(String userId,String thawReason){
        String information = null;
        information = userId+","+thawReason;
        rabbitTemplate.convertAndSend("UserFreezeDirect","userThawFreezeQueue",information);
    }
}
