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
    @RequestMapping("addUser")
    public void addUser( UserEntity userEntity){
       // System.out.println(userEntity.getUserBusinessLicenseImg());
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
   @RequestMapping("getPage")
    @ResponseBody
    public int getPage(){
        return userService.getTotalPage(2);
    }


    @RequestMapping("byStateGetPage")
    @ResponseBody
    public int getTotalNumberByUserState(String userState ){
        if (userState.equals("0")){
            return userService.getTotalPage(2);

        }else {
            return userService.getTotalNumberByUserState(Integer.parseInt(userState),2);
        }
    }
    @RequestMapping("findAllUser")
    @ResponseBody
    public List<UserEntity> findAllUserByState(String userState,String currPage ){
       System.out.println(userState);
        System.out.println(currPage);
      String  pageSize = "2";
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



//        int totalCount=0;
//        PageNationEntity<UserEntity> pageNationEntity = new PageNationEntity<UserEntity>();
//        if(userState.equals("0")){
//            //查询全部时得到总条数
//             totalCount = userService.getTotalNumber();
//            List<UserEntity> list = userService.findAllUser(pageable);
//            pageNationEntity.setTotalCount(totalCount);
//            pageNationEntity.setDataList(list);
//            return pageNationEntity;
//        }else {
//            //根据状态查询数据时的总条数,即某种用户状态下数据总条数
//             totalCount = userService.getTotalNumberByUserState(Integer.parseInt(userState));
//            List<UserEntity> list = userService.findByUserState(Integer.parseInt(userState),pageable);
//            pageNationEntity.setTotalCount(totalCount);
//            pageNationEntity.setDataList(list);
//            return pageNationEntity;
//        }
        //return null;
    }
    @RequestMapping("findByUserId")
    @ResponseBody
    public UserEntity findByUserId(String userId){
        return userService.findByUserId(userId);
    }
}
