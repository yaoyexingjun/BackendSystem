package com.lovo.backend.controller;

import com.lovo.backend.entity.UserEntity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 监听对列，接收消息
 * 吴涛
 */
@Component
public class GetUserInformationController {
    @Autowired
    private UserController userController;
    //监听userQueue对列
    //@RabbitListener(queues = "userQueue")
    public void userRegister(UserEntity userEntity){
        System.out.println(userEntity.getUserName());
        //userController.addUser(userEntity);
    }
    //监听updateQueue对列
    //@RabbitListener(queues = "updateQueue")
    public void userUpdate(String userId,String userPwd,String userPhone){
        System.out.println(userPhone);
    }
    //监听通过审核的冻结对列
   // @RabbitListener(queues = "freezeQueue")
    public void userFreeze(String userId,String causerFreeze){
        System.out.println(causerFreeze);
    }
    //监听通过审核的解冻对列
    //@RabbitListener(queues = "thawFreezeQueue")
    public void userThawFreeze(String userId,String thawReason){
        System.out.println(thawReason);
    }

}
