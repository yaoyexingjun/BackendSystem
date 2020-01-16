package com.lovo.backend.controller;

import com.lovo.backend.entity.UserEntity;
import com.lovo.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("addUser")
    public void addUser( UserEntity userEntity){
       userService.registerUser(userEntity);
    }
    @RequestMapping("updateUserPwdAndUserPhone")
    public void updateUserPwdAndUserPhone(String userId,String userPwd,String userPhone){
        userService.updateUserPwdAndUserPhone(userId,userPwd,userPhone);
    }
    @RequestMapping("updateUserState")
    public void updateUserState(String userId, Integer userState,String causerFreeze,String thawReason){
        userService.updateUserState(userId,userState,causerFreeze,thawReason);
    }
    @RequestMapping("login")
    public UserEntity findByUserNameAndUserPwd(String userName, String userPwd){
       return userService.findByUserNameAndUserPwd(userName,userPwd);
    }
    @RequestMapping("findAllUser")
    public List<UserEntity> findAllUserByState(int userState, Pageable pageable){

       //return userService.findAllUser(userState,pageable);
        return null;
    }
    @RequestMapping("findById")
    public UserEntity findById(String userId){
        return userService.findById(userId);
    }
}
