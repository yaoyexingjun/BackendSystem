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
    //监听修改用户信息updateQueue对列
    //@RabbitListener(queues = "updateQueue")
    public void userUpdate(String information){
        String[] arr = information.split(",");
        String userId=null;
        String userPwd=null;
        String userPhone=null;
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        //
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
