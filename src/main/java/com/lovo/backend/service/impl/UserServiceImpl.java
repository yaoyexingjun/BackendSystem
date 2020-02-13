package com.lovo.backend.service.impl;

import com.lovo.backend.dao.IUserDao;
import com.lovo.backend.entity.UserEntity;
import com.lovo.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements IUserService {



    @Autowired
    private IUserDao userDao;



    public int getTotalNumber() {
        return userDao.getTotalNumber();
    }

    public int getTotalNumberByUserState(int userState) {
        return userDao.getTotalNumberByUserState(userState);
    }

    public void registerUser(UserEntity userEntity) {

        userDao.save(userEntity);
    }

    public void updateUserPwdAndUserPhone(String userId, String userPwd, String userPhone) {
        userDao.updateUserPwdAndUserPhone(userId,userPwd,userPhone);
    }


    public void updateUserStateAndCauserFreezeByUserId(String userId, int userState, String causerFreeze) {
        userDao.updateUserStateAndCauserFreezeByUserId(userId,userState,causerFreeze);
    }


    public void updateUserStateAndThawReasonByUserId(String userId, int userState, String thawReason) {
        userDao.updateUserStateAndThawReasonByUserId(userId,userState,thawReason);
    }

//    public void updateUserState(String userId, int userState,String causerFreeze,String thawReason) {
//        userDao.updateUserState(userId,userState,causerFreeze,thawReason);
//    }


    public UserEntity findByUserNameAndUserPwd(String userName, String userPwd) {
        return userDao.findByUserNameAndUserPwd(userName,userPwd);
    }


    public List<UserEntity> findAllUser(Pageable pageable) {

        return  userDao.findAllUser(pageable);
    }

    public UserEntity findByUserId(String userId) {
        return userDao.findByUserId(userId);
    }

    public UserEntity findById(Long userId) {
        return  userDao.findById(userId).get();
    }


    public List<UserEntity> findByUserState(int userState, Pageable pageable) {
        return userDao.findByUserState(userState,pageable);
    }


    public int getTotalPage(int pageSize) {
        //return (userDao.getTotalNumber()+pageSize-1)/pageSize;
        return ((int)userDao.count()+pageSize-1)/pageSize;
    }


    public int getTotalNumberByUserState(int userState, int pageSize) {
        return (userDao.getTotalNumberByUserState(userState)+pageSize-1)/pageSize;
    }
}
