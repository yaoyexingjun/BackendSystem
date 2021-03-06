package com.lovo.backend.controller;

import com.lovo.backend.entity.PageNationEntity;
import com.lovo.backend.entity.UserEntity;
import com.lovo.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    //添加用户的数据
    @RequestMapping("addUser")
    public void addUser( UserEntity userEntity){
       // System.out.println(userEntity.getUserBusinessLicenseImg());
       userService.registerUser(userEntity);
    }
    //修改用户的密码和电话
    @RequestMapping("updateUserPwdAndUserPhone")
    @ResponseBody
    public void updateUserPwdAndUserPhone(String userId,String userPwd,String userPhone){
        userService.updateUserPwdAndUserPhone(userId,userPwd,userPhone);
    }

    //修改用户的状态及冻结原因
    @RequestMapping("updateUserStateAndCauserFreeze")
    @ResponseBody
    public void updateUserStateAndCauserFreeze(String userId,String causerFreeze){

        userService.updateUserStateAndCauserFreezeByUserId(userId,Integer.parseInt("2"),causerFreeze);
    }
    //修改用户的状态及解除冻结原因
    @RequestMapping("updateUserStateAndThawReason")
    @ResponseBody
    public void updateUserStateAndThawReason(String userId,String thawReason){
        userService.updateUserStateAndThawReasonByUserId(userId,Integer.parseInt("1"),thawReason);
    }
    //根据用户名和密码得到用户对象
    @RequestMapping("login")
    @ResponseBody
    public UserEntity findByUserNameAndUserPwd(String userName, String userPwd){
       return userService.findByUserNameAndUserPwd(userName,userPwd);
    }
    //得到初始化时的总页数
   @RequestMapping("getPage")
    @ResponseBody
    public int getPage(){
        return userService.getTotalPage(5);
    }

    //根据用户状态得到总页数
    @RequestMapping("byStateGetPage")
    @ResponseBody
    public int getTotalNumberByUserState(String userState ){
        if (userState.equals("0")){
            return userService.getTotalPage(5);

        }else {
            return userService.getTotalNumberByUserState(Integer.parseInt(userState),5);
        }
    }
    @RequestMapping("findAllUser")
    @ResponseBody
    public List<UserEntity> findAllUserByState(String userState,String currPage ){
       System.out.println(userState);
        System.out.println(currPage);
      String  pageSize = "5";
      //当前页为空，代表是初始化状态
       if (currPage == null){
            currPage="1";
        }
        Pageable   pageable = PageRequest.of(Integer.parseInt(currPage)-1,Integer.parseInt(pageSize));

       if (userState.equals("0") ){
            List<UserEntity> list = userService.findAllUser(pageable);
            return list;
       }else{
           List<UserEntity> list = userService.findByUserState(Integer.parseInt(userState),pageable);
            return list;
       }
    }
    //根据用户的userId得到用户对象
    @RequestMapping("findByUserId")
    @ResponseBody
    public UserEntity findByUserId(String userId){
        return userService.findByUserId(userId);
    }
}
