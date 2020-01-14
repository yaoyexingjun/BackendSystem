package com.lovo.backend.dao;

import com.lovo.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserDao extends CrudRepository<UserEntity,String> {
    /**
     * 根据用户id修改用户的密码和电话
     * @param userId 用户id
     * @param userPwd 用户密码
     * @param userPhone 用户电话
     */
    @Query("update UserEntity set userPwd=?2,userPhone=?3 where userId=?1")
    @Modifying
    public void updateUserPwdAndUserPhone(String userId,String userPwd,String userPhone);

    /**
     * 根据id修改用户的用户状态
     * @param userId 用户id
     * @param userState 用户状态
     */
    @Query("update UserEntity set userState =?2 where userId =?1")
    @Modifying
    public void updateUserState(String userId,int userState);

    /**
     * 根据用户名和用户密码查询用户对象
     * @param userName 用户名
     * @param userPwd 用户密码
     * @return 用户对象
     */
    @Query("from UserEntity where userName=?1 and userPwd=?2")
    public UserEntity findByUserNameAndUserPwd(String userName,String userPwd);

    /**
     * 查询所有用户
     * @return 用户对象集合
     */
    @Query("from UserEntity order by userState")
    public List<UserEntity> findAllUser();
}
