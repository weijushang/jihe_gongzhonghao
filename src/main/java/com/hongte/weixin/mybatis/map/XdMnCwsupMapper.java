package com.hongte.weixin.mybatis.map;

import com.hongte.weixin.mybatis.domain.XdMnCwsup;
import com.hongte.weixin.mybatis.domain.XdMnCwsupExample;
import com.hongte.weixin.mybatis.domain.XdMnCwsupKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XdMnCwsupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    int countByExample(XdMnCwsupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    int deleteByExample(XdMnCwsupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(XdMnCwsupKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    int insert(XdMnCwsup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    int insertSelective(XdMnCwsup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    List<XdMnCwsup> selectByExample(XdMnCwsupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    XdMnCwsup selectByPrimaryKey(XdMnCwsupKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") XdMnCwsup record, @Param("example") XdMnCwsupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") XdMnCwsup record, @Param("example") XdMnCwsupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(XdMnCwsup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(XdMnCwsup record);
}