package org.accp.office.pojo;

import java.util.ArrayList;
import java.util.List;

public class ReviewStateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReviewStateExample() {
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

        public Criteria andReviewStateIdIsNull() {
            addCriterion("review_state_id is null");
            return (Criteria) this;
        }

        public Criteria andReviewStateIdIsNotNull() {
            addCriterion("review_state_id is not null");
            return (Criteria) this;
        }

        public Criteria andReviewStateIdEqualTo(Integer value) {
            addCriterion("review_state_id =", value, "reviewStateId");
            return (Criteria) this;
        }

        public Criteria andReviewStateIdNotEqualTo(Integer value) {
            addCriterion("review_state_id <>", value, "reviewStateId");
            return (Criteria) this;
        }

        public Criteria andReviewStateIdGreaterThan(Integer value) {
            addCriterion("review_state_id >", value, "reviewStateId");
            return (Criteria) this;
        }

        public Criteria andReviewStateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_state_id >=", value, "reviewStateId");
            return (Criteria) this;
        }

        public Criteria andReviewStateIdLessThan(Integer value) {
            addCriterion("review_state_id <", value, "reviewStateId");
            return (Criteria) this;
        }

        public Criteria andReviewStateIdLessThanOrEqualTo(Integer value) {
            addCriterion("review_state_id <=", value, "reviewStateId");
            return (Criteria) this;
        }

        public Criteria andReviewStateIdIn(List<Integer> values) {
            addCriterion("review_state_id in", values, "reviewStateId");
            return (Criteria) this;
        }

        public Criteria andReviewStateIdNotIn(List<Integer> values) {
            addCriterion("review_state_id not in", values, "reviewStateId");
            return (Criteria) this;
        }

        public Criteria andReviewStateIdBetween(Integer value1, Integer value2) {
            addCriterion("review_state_id between", value1, value2, "reviewStateId");
            return (Criteria) this;
        }

        public Criteria andReviewStateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("review_state_id not between", value1, value2, "reviewStateId");
            return (Criteria) this;
        }

        public Criteria andReviewStateResultIsNull() {
            addCriterion("review_state_result is null");
            return (Criteria) this;
        }

        public Criteria andReviewStateResultIsNotNull() {
            addCriterion("review_state_result is not null");
            return (Criteria) this;
        }

        public Criteria andReviewStateResultEqualTo(String value) {
            addCriterion("review_state_result =", value, "reviewStateResult");
            return (Criteria) this;
        }

        public Criteria andReviewStateResultNotEqualTo(String value) {
            addCriterion("review_state_result <>", value, "reviewStateResult");
            return (Criteria) this;
        }

        public Criteria andReviewStateResultGreaterThan(String value) {
            addCriterion("review_state_result >", value, "reviewStateResult");
            return (Criteria) this;
        }

        public Criteria andReviewStateResultGreaterThanOrEqualTo(String value) {
            addCriterion("review_state_result >=", value, "reviewStateResult");
            return (Criteria) this;
        }

        public Criteria andReviewStateResultLessThan(String value) {
            addCriterion("review_state_result <", value, "reviewStateResult");
            return (Criteria) this;
        }

        public Criteria andReviewStateResultLessThanOrEqualTo(String value) {
            addCriterion("review_state_result <=", value, "reviewStateResult");
            return (Criteria) this;
        }

        public Criteria andReviewStateResultLike(String value) {
            addCriterion("review_state_result like", value, "reviewStateResult");
            return (Criteria) this;
        }

        public Criteria andReviewStateResultNotLike(String value) {
            addCriterion("review_state_result not like", value, "reviewStateResult");
            return (Criteria) this;
        }

        public Criteria andReviewStateResultIn(List<String> values) {
            addCriterion("review_state_result in", values, "reviewStateResult");
            return (Criteria) this;
        }

        public Criteria andReviewStateResultNotIn(List<String> values) {
            addCriterion("review_state_result not in", values, "reviewStateResult");
            return (Criteria) this;
        }

        public Criteria andReviewStateResultBetween(String value1, String value2) {
            addCriterion("review_state_result between", value1, value2, "reviewStateResult");
            return (Criteria) this;
        }

        public Criteria andReviewStateResultNotBetween(String value1, String value2) {
            addCriterion("review_state_result not between", value1, value2, "reviewStateResult");
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