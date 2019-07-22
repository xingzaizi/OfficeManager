package org.accp.office.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExpenditureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpenditureExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andExpenditureIdIsNull() {
            addCriterion("expenditure_id is null");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdIsNotNull() {
            addCriterion("expenditure_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdEqualTo(String value) {
            addCriterion("expenditure_id =", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdNotEqualTo(String value) {
            addCriterion("expenditure_id <>", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdGreaterThan(String value) {
            addCriterion("expenditure_id >", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdGreaterThanOrEqualTo(String value) {
            addCriterion("expenditure_id >=", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdLessThan(String value) {
            addCriterion("expenditure_id <", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdLessThanOrEqualTo(String value) {
            addCriterion("expenditure_id <=", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdLike(String value) {
            addCriterion("expenditure_id like", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdNotLike(String value) {
            addCriterion("expenditure_id not like", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdIn(List<String> values) {
            addCriterion("expenditure_id in", values, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdNotIn(List<String> values) {
            addCriterion("expenditure_id not in", values, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdBetween(String value1, String value2) {
            addCriterion("expenditure_id between", value1, value2, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdNotBetween(String value1, String value2) {
            addCriterion("expenditure_id not between", value1, value2, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("total_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("total_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(Float value) {
            addCriterion("total_money =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(Float value) {
            addCriterion("total_money <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(Float value) {
            addCriterion("total_money >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("total_money >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(Float value) {
            addCriterion("total_money <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(Float value) {
            addCriterion("total_money <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<Float> values) {
            addCriterion("total_money in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<Float> values) {
            addCriterion("total_money not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(Float value1, Float value2) {
            addCriterion("total_money between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(Float value1, Float value2) {
            addCriterion("total_money not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Integer value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Integer value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Integer value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Integer value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Integer value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Integer> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Integer> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Integer value1, Integer value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Integer value1, Integer value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andDisposeByIsNull() {
            addCriterion("dispose_by is null");
            return (Criteria) this;
        }

        public Criteria andDisposeByIsNotNull() {
            addCriterion("dispose_by is not null");
            return (Criteria) this;
        }

        public Criteria andDisposeByEqualTo(Integer value) {
            addCriterion("dispose_by =", value, "disposeBy");
            return (Criteria) this;
        }

        public Criteria andDisposeByNotEqualTo(Integer value) {
            addCriterion("dispose_by <>", value, "disposeBy");
            return (Criteria) this;
        }

        public Criteria andDisposeByGreaterThan(Integer value) {
            addCriterion("dispose_by >", value, "disposeBy");
            return (Criteria) this;
        }

        public Criteria andDisposeByGreaterThanOrEqualTo(Integer value) {
            addCriterion("dispose_by >=", value, "disposeBy");
            return (Criteria) this;
        }

        public Criteria andDisposeByLessThan(Integer value) {
            addCriterion("dispose_by <", value, "disposeBy");
            return (Criteria) this;
        }

        public Criteria andDisposeByLessThanOrEqualTo(Integer value) {
            addCriterion("dispose_by <=", value, "disposeBy");
            return (Criteria) this;
        }

        public Criteria andDisposeByIn(List<Integer> values) {
            addCriterion("dispose_by in", values, "disposeBy");
            return (Criteria) this;
        }

        public Criteria andDisposeByNotIn(List<Integer> values) {
            addCriterion("dispose_by not in", values, "disposeBy");
            return (Criteria) this;
        }

        public Criteria andDisposeByBetween(Integer value1, Integer value2) {
            addCriterion("dispose_by between", value1, value2, "disposeBy");
            return (Criteria) this;
        }

        public Criteria andDisposeByNotBetween(Integer value1, Integer value2) {
            addCriterion("dispose_by not between", value1, value2, "disposeBy");
            return (Criteria) this;
        }

        public Criteria andApprovalStateIdIsNull() {
            addCriterion("approval_state_id is null");
            return (Criteria) this;
        }

        public Criteria andApprovalStateIdIsNotNull() {
            addCriterion("approval_state_id is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalStateIdEqualTo(Integer value) {
            addCriterion("approval_state_id =", value, "approvalStateId");
            return (Criteria) this;
        }

        public Criteria andApprovalStateIdNotEqualTo(Integer value) {
            addCriterion("approval_state_id <>", value, "approvalStateId");
            return (Criteria) this;
        }

        public Criteria andApprovalStateIdGreaterThan(Integer value) {
            addCriterion("approval_state_id >", value, "approvalStateId");
            return (Criteria) this;
        }

        public Criteria andApprovalStateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("approval_state_id >=", value, "approvalStateId");
            return (Criteria) this;
        }

        public Criteria andApprovalStateIdLessThan(Integer value) {
            addCriterion("approval_state_id <", value, "approvalStateId");
            return (Criteria) this;
        }

        public Criteria andApprovalStateIdLessThanOrEqualTo(Integer value) {
            addCriterion("approval_state_id <=", value, "approvalStateId");
            return (Criteria) this;
        }

        public Criteria andApprovalStateIdIn(List<Integer> values) {
            addCriterion("approval_state_id in", values, "approvalStateId");
            return (Criteria) this;
        }

        public Criteria andApprovalStateIdNotIn(List<Integer> values) {
            addCriterion("approval_state_id not in", values, "approvalStateId");
            return (Criteria) this;
        }

        public Criteria andApprovalStateIdBetween(Integer value1, Integer value2) {
            addCriterion("approval_state_id between", value1, value2, "approvalStateId");
            return (Criteria) this;
        }

        public Criteria andApprovalStateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("approval_state_id not between", value1, value2, "approvalStateId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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