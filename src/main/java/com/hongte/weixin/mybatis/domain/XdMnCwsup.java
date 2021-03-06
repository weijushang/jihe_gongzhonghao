package com.hongte.weixin.mybatis.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class XdMnCwsup extends XdMnCwsupKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.XD_MN_CWSup.FSupply
     *
     * @mbggenerated
     */
    private Integer fsupply;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.XD_MN_CWSup.FAmount
     *
     * @mbggenerated
     */
    private BigDecimal famount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.XD_MN_CWSup.FDebit
     *
     * @mbggenerated
     */
    private BigDecimal fdebit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.XD_MN_CWSup.FRate
     *
     * @mbggenerated
     */
    private BigDecimal frate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.XD_MN_CWSup.FSupply
     *
     * @return the value of dbo.XD_MN_CWSup.FSupply
     *
     * @mbggenerated
     */
    public Integer getFsupply() {
        return fsupply;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.XD_MN_CWSup.FSupply
     *
     * @param fsupply the value for dbo.XD_MN_CWSup.FSupply
     *
     * @mbggenerated
     */
    public void setFsupply(Integer fsupply) {
        this.fsupply = fsupply;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.XD_MN_CWSup.FAmount
     *
     * @return the value of dbo.XD_MN_CWSup.FAmount
     *
     * @mbggenerated
     */
    public BigDecimal getFamount() {
        return famount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.XD_MN_CWSup.FAmount
     *
     * @param famount the value for dbo.XD_MN_CWSup.FAmount
     *
     * @mbggenerated
     */
    public void setFamount(BigDecimal famount) {
        this.famount = famount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.XD_MN_CWSup.FDebit
     *
     * @return the value of dbo.XD_MN_CWSup.FDebit
     *
     * @mbggenerated
     */
    public BigDecimal getFdebit() {
        return fdebit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.XD_MN_CWSup.FDebit
     *
     * @param fdebit the value for dbo.XD_MN_CWSup.FDebit
     *
     * @mbggenerated
     */
    public void setFdebit(BigDecimal fdebit) {
        this.fdebit = fdebit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.XD_MN_CWSup.FRate
     *
     * @return the value of dbo.XD_MN_CWSup.FRate
     *
     * @mbggenerated
     */
    public BigDecimal getFrate() {
        return frate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.XD_MN_CWSup.FRate
     *
     * @param frate the value for dbo.XD_MN_CWSup.FRate
     *
     * @mbggenerated
     */
    public void setFrate(BigDecimal frate) {
        this.frate = frate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        XdMnCwsup other = (XdMnCwsup) that;
        return (this.getFid() == null ? other.getFid() == null : this.getFid().equals(other.getFid()))
            && (this.getFentryid() == null ? other.getFentryid() == null : this.getFentryid().equals(other.getFentryid()))
            && (this.getFsupply() == null ? other.getFsupply() == null : this.getFsupply().equals(other.getFsupply()))
            && (this.getFamount() == null ? other.getFamount() == null : this.getFamount().equals(other.getFamount()))
            && (this.getFdebit() == null ? other.getFdebit() == null : this.getFdebit().equals(other.getFdebit()))
            && (this.getFrate() == null ? other.getFrate() == null : this.getFrate().equals(other.getFrate()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFid() == null) ? 0 : getFid().hashCode());
        result = prime * result + ((getFentryid() == null) ? 0 : getFentryid().hashCode());
        result = prime * result + ((getFsupply() == null) ? 0 : getFsupply().hashCode());
        result = prime * result + ((getFamount() == null) ? 0 : getFamount().hashCode());
        result = prime * result + ((getFdebit() == null) ? 0 : getFdebit().hashCode());
        result = prime * result + ((getFrate() == null) ? 0 : getFrate().hashCode());
        return result;
    }
}