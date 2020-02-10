package com.lovo.backend.service;

import com.lovo.backend.entity.UserEntity;
import org.springframework.data.domain.Pageable;
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

    public void updateUserState(String userId,int userState,String causerFreeze,String thawReason);

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
    public List<UserEntity> findAllUser(Pageable pageable);

    /**
     * 根据id查询用户对象
     * @param userId 用户id
     * @return 用户对象
     */
    public UserEntity findById(Long userId);

    /**
     * 根据userId查询用户对象
     * @param userId 用户的userId
     * @return 用户对象
     */
    public UserEntity findByUserId(String userId);
    /**
     * 根据状态查询用户对象集合
     * @param userState 用户状态
     * @param pageable 分页插件
     * @return 用户对象集合
     */
    public List<UserEntity> findByUserState(int userState,Pageable pageable);

    /**
     * 得到总页数
     * @return 总页数
     */
    public int getTotalPage(int pageSize);

    /**
     * 根据用户状态及每页记录数得到总页数
     * @param userState 用户状态
     * @param pageSize 每页记录数
     * @return 相应用户状态下的总页数
     */
    public int getTotalNumberByUserState(int userState,int pageSize);

    /**
     * 统计总记录条数
     * @return 总记录条数
     */
    public int getTotalNumber();

    /**
     * 根据用户状态查询用户的总记录数
     * @param userState
     * @return 总记录数
     */
    public int getTotalNumberByUserState(int userState);
}
