package com.sfsctech.framework.model.domain;


import com.sfsctech.core.base.domain.dto.BaseDto;

import java.util.Date;

public class TSysUser extends BaseDto {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.Guid
     *
     * @mbg.generated
     */
    private Long guid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.UserName
     *
     * @mbg.generated
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.PassWord
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.Email
     *
     * @mbg.generated
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.Remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.Creator
     *
     * @mbg.generated
     */
    private Long creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.CreateTime
     *
     * @mbg.generated
     */
    private Date createtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.Updater
     *
     * @mbg.generated
     */
    private Long updater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.UpdateTime
     *
     * @mbg.generated
     */
    private Date updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.Guid
     *
     * @return the value of t_sys_user.Guid
     *
     * @mbg.generated
     */
    public Long getGuid() {
        return guid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.Guid
     *
     * @param guid the value for t_sys_user.Guid
     *
     * @mbg.generated
     */
    public void setGuid(Long guid) {
        this.guid = guid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.UserName
     *
     * @return the value of t_sys_user.UserName
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.UserName
     *
     * @param username the value for t_sys_user.UserName
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.PassWord
     *
     * @return the value of t_sys_user.PassWord
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.PassWord
     *
     * @param password the value for t_sys_user.PassWord
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.Email
     *
     * @return the value of t_sys_user.Email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.Email
     *
     * @param email the value for t_sys_user.Email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.Remark
     *
     * @return the value of t_sys_user.Remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.Remark
     *
     * @param remark the value for t_sys_user.Remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.Creator
     *
     * @return the value of t_sys_user.Creator
     *
     * @mbg.generated
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.Creator
     *
     * @param creator the value for t_sys_user.Creator
     *
     * @mbg.generated
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.CreateTime
     *
     * @return the value of t_sys_user.CreateTime
     *
     * @mbg.generated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.CreateTime
     *
     * @param createtime the value for t_sys_user.CreateTime
     *
     * @mbg.generated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.Updater
     *
     * @return the value of t_sys_user.Updater
     *
     * @mbg.generated
     */
    public Long getUpdater() {
        return updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.Updater
     *
     * @param updater the value for t_sys_user.Updater
     *
     * @mbg.generated
     */
    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.UpdateTime
     *
     * @return the value of t_sys_user.UpdateTime
     *
     * @mbg.generated
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.UpdateTime
     *
     * @param updatetime the value for t_sys_user.UpdateTime
     *
     * @mbg.generated
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}