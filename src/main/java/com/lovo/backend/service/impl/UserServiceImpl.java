package com.lovo.backend.service.impl;

import com.lovo.backend.dao.IUserDao;
import com.lovo.backend.entity.UserEntity;
import com.lovo.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    public void registerUser(UserEntity userEntity) {

        userDao.save(userEntity);
    }

    public void updateUserPwdAndUserPhone(String userId, String userPwd, String userPhone) {
        userDao.updateUserPwdAndUserPhone(userId,userPwd,userPhone);
    }


    public void updateUserState(String userId, int userState) {
        userDao.updateUserState(userId,userState);
    }


    public UserEntity findByUserNameAndUserPwd(String userName, String userPwd) {
        return userDao.findByUserNameAndUserPwd(userName,userPwd);
    }


    public List<UserEntity> findAllUser() {

        return  userDao.findAllUser();
    }


    public UserEntity findById(String userId) {
        return  userDao.findById(userId).get();
    }

}
