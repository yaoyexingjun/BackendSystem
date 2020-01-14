package com.lovo.backend.service;

import com.lovo.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserService {
    /**
     * 用户注册
     * @param userEntity 用户对象
     */
    public void registerUser(UserEntity userEntity);

    /**
     * 根据用户id修改用户的密码和电话
     * @param userId 用户id
     * @param userPwd 用户密码
     * @param userPhone 用户电话
     */

    public void updateUserPwdAndUserPhone(String userId,String userPwd,String userPhone);

    /**
     * 根据id修改用户的用户状态
     * @param userId 用户id
     * @param userState 用户状态
     */

    public void updateUserState(String userId,int userState);

    /**
     * 根据用户名和用户密码查询用户对象
     * @param userName 用户名
     * @param userPwd 用户密码
     * @return 用户对象
     */

    public UserEntity findByUserNameAndUserPwd(String userName,String userPwd);

    /**
     * 查询所有用户
     * @return 用户对象集合
     */
    public List<UserEntity> findAllUser();

    /**
     * 根据id查询用户对象
     * @param userId 用户id
     * @return 用户对象
     */
    public UserEntity findById(String userId);
}
