package com.lovo.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_user")
public class UserEntity {
    /**用户id*/
    @Id

    @Column(name = "user_id" ,length = 32)
    private String userId;
    /**用户名*/
    @Column(name = "user_name",length = 48)
    private String userName;
    /**用户密码*/
    @Column(name = "user_pwd",length = 48)
    private String userPwd;
    /**用户真实姓名*/
    @Column(name = "user_real_name",length = 48)
    private String userRealName;
    /**用户性别*/
    @Column(name = "user_sex",length = 8)
    private String userSex;
    /**用户电话*/
    @Column(name = "user_phone",length = 32)
    private String userPhone;
    /**公司名称*/
    @Column(name = "user_company_name",length = 80)
    private String userCompanyName;
    /**身份证号*/
    @Column(name = "user_real_id",length = 48)
    private String userRealId;
    /**用户状态*/
    @Column(name = "user_state")
    private  int userState = 1;//0代表未通过审核未冻结，1代表通过审核未冻结，2代表通过审核已冻结
    /**营业执照*/
    @Column(name = "user_business_license_img",columnDefinition = "text")
    private String userBusinessLicenseImg;
    /**身份证照片*/
    @Column(name = "user_userImg",columnDefinition = "text")
    private String userImg;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserCompanyName() {
        return userCompanyName;
    }

    public void setUserCompanyName(String userCompanyName) {
        this.userCompanyName = userCompanyName;
    }

    public String getUserRealId() {
        return userRealId;
    }

    public void setUserRealId(String userRealId) {
        this.userRealId = userRealId;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }

    public String getUserBusinessLicenseImg() {
        return userBusinessLicenseImg;
    }

    public void setUserBusinessLicenseImg(String userBusinessLicenseImg) {
        this.userBusinessLicenseImg = userBusinessLicenseImg;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }
}
