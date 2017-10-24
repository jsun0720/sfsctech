package com.sfsctech.mybatis.dao;

import com.github.pagehelper.PageInfo;
import com.sfsctech.base.model.PagingInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Class IBaseDao
 *
 * @author 张麒 2017/6/30.
 * @version Description:
 */
public interface IBaseDao<T, PK extends Serializable, Example> {

    /**
     * This method was generated by MyBatis Generator.
     */
    List<T> selectByExample(Example example);

    /**
     * This method was generated by MyBatis Generator.
     */
    T selectByPrimaryKey(PK key);

    /**
     * This method was generated by MyBatis Generator for Cache.
     */
    T selectByPrimaryKeyForCache(PK key);

    /**
     * This method was generated by MyBatis Generator.
     */
    int deleteByPrimaryKey(PK key);

    /**
     * This method was generated by MyBatis Generator for Cache.
     */
    int deleteByPrimaryKeyForCache(PK key);

    /**
     * This method was generated by MyBatis Generator.
     */
    int deleteByExample(Example example);

    /**
     * This method was generated by MyBatis Generator for Cache.
     */
    int deleteByExampleForCache(Example example);

    /**
     * This method was generated by MyBatis Generator.
     */
    int insert(T model);

    /**
     * This method was generated by MyBatis Generator for Cache.
     */
    int insertForCache(T model);

    /**
     * This method was generated by MyBatis Generator.
     */
    int insertSelective(T model);

    /**
     * This method was generated by MyBatis Generator for Cache.
     */
    int insertSelectiveForCache(T model);

    /**
     * This method was generated by MyBatis Generator.
     */
    long countByExample(Example example);

    /**
     * This method was generated by MyBatis Generator.
     */
    int updateByExampleSelective(T model, Example example);

    /**
     * This method was generated by MyBatis Generator for Cache.
     */
    int updateByExampleSelectiveForCache(T model, Example example);

    /**
     * This method was generated by MyBatis Generator.
     */
    int updateByExample(T model, Example example);

    /**
     * This method was generated by MyBatis Generator for Cache.
     */
    int updateByExampleForCache(T model, Example example);

    /**
     * This method was generated by MyBatis Generator.
     */
    int updateByPrimaryKeySelective(T model);

    /**
     * This method was generated by MyBatis Generator for Cache.
     */
    int updateByPrimaryKeySelectiveForCache(T model);

    /**
     * This method was generated by MyBatis Generator.
     */
    int updateByPrimaryKey(T model);

    /**
     * This method was generated by MyBatis Generator for Cache.
     */
    int updateByPrimaryKeyForCache(T model);

    boolean checkUnique(Example example, String fieldName, Object condition);

    PageInfo<T> queryPagination(int pageNum, int pageSize, Example example);

    PageInfo<T> queryPagination(PagingInfo<T> paging);
}
