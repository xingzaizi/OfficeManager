package org.accp.office.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LeaveRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LeaveRecordExample() {
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

        public Criteria andLeaveIdIsNull() {
            addCriterion("leave_id is null");
            return (Criteria) this;
        }

        public Criteria andLeaveIdIsNotNull() {
            addCriterion("leave_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveIdEqualTo(Integer value) {
            addCriterion("leave_id =", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdNotEqualTo(Integer value) {
            addCriterion("leave_id <>", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdGreaterThan(Integer value) {
            addCriterion("leave_id >", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("leave_id >=", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdLessThan(Integer value) {
            addCriterion("leave_id <", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdLessThanOrEqualTo(Integer value) {
            addCriterion("leave_id <=", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdIn(List<Integer> values) {
            addCriterion("leave_id in", values, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdNotIn(List<Integer> values) {
            addCriterion("leave_id not in", values, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdBetween(Integer value1, Integer value2) {
            addCriterion("leave_id between", value1, value2, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("leave_id not between", value1, value2, "leaveId");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysIsNull() {
            addCriterion("leave_days is null");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysIsNotNull() {
            addCriterion("leave_days is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysEqualTo(Integer value) {
            addCriterion("leave_days =", value, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysNotEqualTo(Integer value) {
            addCriterion("leave_days <>", value, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysGreaterThan(Integer value) {
            addCriterion("leave_days >", value, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("leave_days >=", value, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysLessThan(Integer value) {
            addCriterion("leave_days <", value, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysLessThanOrEqualTo(Integer value) {
            addCriterion("leave_days <=", value, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysIn(List<Integer> values) {
            addCriterion("leave_days in", values, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysNotIn(List<Integer> values) {
            addCriterion("leave_days not in", values, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysBetween(Integer value1, Integer value2) {
            addCriterion("leave_days between", value1, value2, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("leave_days not between", value1, value2, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andLeaveByIsNull() {
            addCriterion("leave_by is null");
            return (Criteria) this;
        }

        public Criteria andLeaveByIsNotNull() {
            addCriterion("leave_by is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveByEqualTo(Integer value) {
            addCriterion("leave_by =", value, "leaveBy");
            return (Criteria) this;
        }

        public Criteria andLeaveByNotEqualTo(Integer value) {
            addCriterion("leave_by <>", value, "leaveBy");
            return (Criteria) this;
        }

        public Criteria andLeaveByGreaterThan(Integer value) {
            addCriterion("leave_by >", value, "leaveBy");
            return (Criteria) this;
        }

        public Criteria andLeaveByGreaterThanOrEqualTo(Integer value) {
            addCriterion("leave_by >=", value, "leaveBy");
            return (Criteria) this;
        }

        public Criteria andLeaveByLessThan(Integer value) {
            addCriterion("leave_by <", value, "leaveBy");
            return (Criteria) this;
        }

        public Criteria andLeaveByLessThanOrEqualTo(Integer value) {
            addCriterion("leave_by <=", value, "leaveBy");
            return (Criteria) this;
        }

        public Criteria andLeaveByIn(List<Integer> values) {
            addCriterion("leave_by in", values, "leaveBy");
            return (Criteria) this;
        }

        public Criteria andLeaveByNotIn(List<Integer> values) {
            addCriterion("leave_by not in", values, "leaveBy");
            return (Criteria) this;
        }

        public Criteria andLeaveByBetween(Integer value1, Integer value2) {
            addCriterion("leave_by between", value1, value2, "leaveBy");
            return (Criteria) this;
        }

        public Criteria andLeaveByNotBetween(Integer value1, Integer value2) {
            addCriterion("leave_by not between", value1, value2, "leaveBy");
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