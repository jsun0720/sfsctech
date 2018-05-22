package com.sfsctech.framework.model.domain;

import com.sfsctech.core.base.domain.dto.BaseDto;
import com.sfsctech.core.spring.constants.VerifyConstants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

public class TSysAccount extends BaseDto {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_account.Guid
     *
     * @mbg.generated
     */
    private Long guid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_account.UserGuid
     *
     * @mbg.generated
     */
    private Long userguid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_account.Account
     *
     * @mbg.generated
     */
    @NotBlank
    @Length(min = 5, max = 20, message = VerifyConstants.Length)
    private String account;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_account.Password
     *
     * @mbg.generated
     */
    @NotBlank
    @Length(min = 8, max = 20, message = VerifyConstants.Length)
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_account.InitPassword
     *
     * @mbg.generated
     */
    @NotBlank
    @Length(min = 8, max = 20, message = VerifyConstants.Length)
    private String initpassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_account.Sort
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_account.Enabled
     *
     * @mbg.generated
     */
    private Integer enabled;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_account.Locked
     *
     * @mbg.generated
     */
    private Integer locked;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_account.LockTime
     *
     * @mbg.generated
     */
    private Date locktime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_account.Status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_account.Creator
     *
     * @mbg.generated
     */
    private Long creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_account.CreateTime
     *
     * @mbg.generated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_account.Updater
     *
     * @mbg.generated
     */
    private Long updater;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_account.UpdateTime
     *
     * @mbg.generated
     */
    private Date updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_account.Guid
     *
     * @return the value of t_sys_account.Guid
     * @mbg.generated
     */
    public Long getGuid() {
        return guid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_account.Guid
     *
     * @param guid the value for t_sys_account.Guid
     * @mbg.generated
     */
    public void setGuid(Long guid) {
        this.guid = guid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_account.UserGuid
     *
     * @return the value of t_sys_account.UserGuid
     * @mbg.generated
     */
    public Long getUserguid() {
        return userguid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_account.UserGuid
     *
     * @param userguid the value for t_sys_account.UserGuid
     * @mbg.generated
     */
    public void setUserguid(Long userguid) {
        this.userguid = userguid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_account.Account
     *
     * @return the value of t_sys_account.Account
     * @mbg.generated
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_account.Account
     *
     * @param account the value for t_sys_account.Account
     * @mbg.generated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_account.Password
     *
     * @return the value of t_sys_account.Password
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_account.Password
     *
     * @param password the value for t_sys_account.Password
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_account.InitPassword
     *
     * @return the value of t_sys_account.InitPassword
     * @mbg.generated
     */
    public String getInitpassword() {
        return initpassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_account.InitPassword
     *
     * @param initpassword the value for t_sys_account.InitPassword
     * @mbg.generated
     */
    public void setInitpassword(String initpassword) {
        this.initpassword = initpassword == null ? null : initpassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_account.Sort
     *
     * @return the value of t_sys_account.Sort
     * @mbg.generated
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_account.Sort
     *
     * @param sort the value for t_sys_account.Sort
     * @mbg.generated
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_account.Enabled
     *
     * @return the value of t_sys_account.Enabled
     * @mbg.generated
     */
    public Integer getEnabled() {
        return enabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_account.Enabled
     *
     * @param enabled the value for t_sys_account.Enabled
     * @mbg.generated
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_account.Locked
     *
     * @return the value of t_sys_account.Locked
     * @mbg.generated
     */
    public Integer getLocked() {
        return locked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_account.Locked
     *
     * @param locked the value for t_sys_account.Locked
     * @mbg.generated
     */
    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_account.LockTime
     *
     * @return the value of t_sys_account.LockTime
     * @mbg.generated
     */
    public Date getLocktime() {
        return locktime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_account.LockTime
     *
     * @param locktime the value for t_sys_account.LockTime
     * @mbg.generated
     */
    public void setLocktime(Date locktime) {
        this.locktime = locktime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_account.Status
     *
     * @return the value of t_sys_account.Status
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_account.Status
     *
     * @param status the value for t_sys_account.Status
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_account.Creator
     *
     * @return the value of t_sys_account.Creator
     * @mbg.generated
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_account.Creator
     *
     * @param creator the value for t_sys_account.Creator
     * @mbg.generated
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_account.CreateTime
     *
     * @return the value of t_sys_account.CreateTime
     * @mbg.generated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_account.CreateTime
     *
     * @param createtime the value for t_sys_account.CreateTime
     * @mbg.generated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_account.Updater
     *
     * @return the value of t_sys_account.Updater
     * @mbg.generated
     */
    public Long getUpdater() {
        return updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_account.Updater
     *
     * @param updater the value for t_sys_account.Updater
     * @mbg.generated
     */
    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_account.UpdateTime
     *
     * @return the value of t_sys_account.UpdateTime
     * @mbg.generated
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_account.UpdateTime
     *
     * @param updatetime the value for t_sys_account.UpdateTime
     * @mbg.generated
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}