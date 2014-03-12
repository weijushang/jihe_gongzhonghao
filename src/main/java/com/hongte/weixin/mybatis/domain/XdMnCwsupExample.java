package com.hongte.weixin.mybatis.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class XdMnCwsupExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    public XdMnCwsupExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFidIsNull() {
            addCriterion("FID is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("FID is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("FID =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("FID <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("FID >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FID >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("FID <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("FID <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("FID in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("FID not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("FID between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("FID not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFentryidIsNull() {
            addCriterion("FEntryID is null");
            return (Criteria) this;
        }

        public Criteria andFentryidIsNotNull() {
            addCriterion("FEntryID is not null");
            return (Criteria) this;
        }

        public Criteria andFentryidEqualTo(Integer value) {
            addCriterion("FEntryID =", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidNotEqualTo(Integer value) {
            addCriterion("FEntryID <>", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidGreaterThan(Integer value) {
            addCriterion("FEntryID >", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FEntryID >=", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidLessThan(Integer value) {
            addCriterion("FEntryID <", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidLessThanOrEqualTo(Integer value) {
            addCriterion("FEntryID <=", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidIn(List<Integer> values) {
            addCriterion("FEntryID in", values, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidNotIn(List<Integer> values) {
            addCriterion("FEntryID not in", values, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidBetween(Integer value1, Integer value2) {
            addCriterion("FEntryID between", value1, value2, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidNotBetween(Integer value1, Integer value2) {
            addCriterion("FEntryID not between", value1, value2, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFsupplyIsNull() {
            addCriterion("FSupply is null");
            return (Criteria) this;
        }

        public Criteria andFsupplyIsNotNull() {
            addCriterion("FSupply is not null");
            return (Criteria) this;
        }

        public Criteria andFsupplyEqualTo(Integer value) {
            addCriterion("FSupply =", value, "fsupply");
            return (Criteria) this;
        }

        public Criteria andFsupplyNotEqualTo(Integer value) {
            addCriterion("FSupply <>", value, "fsupply");
            return (Criteria) this;
        }

        public Criteria andFsupplyGreaterThan(Integer value) {
            addCriterion("FSupply >", value, "fsupply");
            return (Criteria) this;
        }

        public Criteria andFsupplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("FSupply >=", value, "fsupply");
            return (Criteria) this;
        }

        public Criteria andFsupplyLessThan(Integer value) {
            addCriterion("FSupply <", value, "fsupply");
            return (Criteria) this;
        }

        public Criteria andFsupplyLessThanOrEqualTo(Integer value) {
            addCriterion("FSupply <=", value, "fsupply");
            return (Criteria) this;
        }

        public Criteria andFsupplyIn(List<Integer> values) {
            addCriterion("FSupply in", values, "fsupply");
            return (Criteria) this;
        }

        public Criteria andFsupplyNotIn(List<Integer> values) {
            addCriterion("FSupply not in", values, "fsupply");
            return (Criteria) this;
        }

        public Criteria andFsupplyBetween(Integer value1, Integer value2) {
            addCriterion("FSupply between", value1, value2, "fsupply");
            return (Criteria) this;
        }

        public Criteria andFsupplyNotBetween(Integer value1, Integer value2) {
            addCriterion("FSupply not between", value1, value2, "fsupply");
            return (Criteria) this;
        }

        public Criteria andFamountIsNull() {
            addCriterion("FAmount is null");
            return (Criteria) this;
        }

        public Criteria andFamountIsNotNull() {
            addCriterion("FAmount is not null");
            return (Criteria) this;
        }

        public Criteria andFamountEqualTo(BigDecimal value) {
            addCriterion("FAmount =", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountNotEqualTo(BigDecimal value) {
            addCriterion("FAmount <>", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountGreaterThan(BigDecimal value) {
            addCriterion("FAmount >", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAmount >=", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountLessThan(BigDecimal value) {
            addCriterion("FAmount <", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAmount <=", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountIn(List<BigDecimal> values) {
            addCriterion("FAmount in", values, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountNotIn(List<BigDecimal> values) {
            addCriterion("FAmount not in", values, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAmount between", value1, value2, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAmount not between", value1, value2, "famount");
            return (Criteria) this;
        }

        public Criteria andFdebitIsNull() {
            addCriterion("FDebit is null");
            return (Criteria) this;
        }

        public Criteria andFdebitIsNotNull() {
            addCriterion("FDebit is not null");
            return (Criteria) this;
        }

        public Criteria andFdebitEqualTo(BigDecimal value) {
            addCriterion("FDebit =", value, "fdebit");
            return (Criteria) this;
        }

        public Criteria andFdebitNotEqualTo(BigDecimal value) {
            addCriterion("FDebit <>", value, "fdebit");
            return (Criteria) this;
        }

        public Criteria andFdebitGreaterThan(BigDecimal value) {
            addCriterion("FDebit >", value, "fdebit");
            return (Criteria) this;
        }

        public Criteria andFdebitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FDebit >=", value, "fdebit");
            return (Criteria) this;
        }

        public Criteria andFdebitLessThan(BigDecimal value) {
            addCriterion("FDebit <", value, "fdebit");
            return (Criteria) this;
        }

        public Criteria andFdebitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FDebit <=", value, "fdebit");
            return (Criteria) this;
        }

        public Criteria andFdebitIn(List<BigDecimal> values) {
            addCriterion("FDebit in", values, "fdebit");
            return (Criteria) this;
        }

        public Criteria andFdebitNotIn(List<BigDecimal> values) {
            addCriterion("FDebit not in", values, "fdebit");
            return (Criteria) this;
        }

        public Criteria andFdebitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FDebit between", value1, value2, "fdebit");
            return (Criteria) this;
        }

        public Criteria andFdebitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FDebit not between", value1, value2, "fdebit");
            return (Criteria) this;
        }

        public Criteria andFrateIsNull() {
            addCriterion("FRate is null");
            return (Criteria) this;
        }

        public Criteria andFrateIsNotNull() {
            addCriterion("FRate is not null");
            return (Criteria) this;
        }

        public Criteria andFrateEqualTo(BigDecimal value) {
            addCriterion("FRate =", value, "frate");
            return (Criteria) this;
        }

        public Criteria andFrateNotEqualTo(BigDecimal value) {
            addCriterion("FRate <>", value, "frate");
            return (Criteria) this;
        }

        public Criteria andFrateGreaterThan(BigDecimal value) {
            addCriterion("FRate >", value, "frate");
            return (Criteria) this;
        }

        public Criteria andFrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FRate >=", value, "frate");
            return (Criteria) this;
        }

        public Criteria andFrateLessThan(BigDecimal value) {
            addCriterion("FRate <", value, "frate");
            return (Criteria) this;
        }

        public Criteria andFrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FRate <=", value, "frate");
            return (Criteria) this;
        }

        public Criteria andFrateIn(List<BigDecimal> values) {
            addCriterion("FRate in", values, "frate");
            return (Criteria) this;
        }

        public Criteria andFrateNotIn(List<BigDecimal> values) {
            addCriterion("FRate not in", values, "frate");
            return (Criteria) this;
        }

        public Criteria andFrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FRate between", value1, value2, "frate");
            return (Criteria) this;
        }

        public Criteria andFrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FRate not between", value1, value2, "frate");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dbo.XD_MN_CWSup
     *
     * @mbggenerated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}