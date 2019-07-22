package org.accp.office.pojo;

import java.util.ArrayList;
import java.util.List;

public class ExpenditureDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpenditureDetailExample() {
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

        public Criteria andExpenditureDetailIdIsNull() {
            addCriterion("expenditure_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andExpenditureDetailIdIsNotNull() {
            addCriterion("expenditure_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpenditureDetailIdEqualTo(Integer value) {
            addCriterion("expenditure_detail_id =", value, "expenditureDetailId");
            return (Criteria) this;
        }

        public Criteria andExpenditureDetailIdNotEqualTo(Integer value) {
            addCriterion("expenditure_detail_id <>", value, "expenditureDetailId");
            return (Criteria) this;
        }

        public Criteria andExpenditureDetailIdGreaterThan(Integer value) {
            addCriterion("expenditure_detail_id >", value, "expenditureDetailId");
            return (Criteria) this;
        }

        public Criteria andExpenditureDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("expenditure_detail_id >=", value, "expenditureDetailId");
            return (Criteria) this;
        }

        public Criteria andExpenditureDetailIdLessThan(Integer value) {
            addCriterion("expenditure_detail_id <", value, "expenditureDetailId");
            return (Criteria) this;
        }

        public Criteria andExpenditureDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("expenditure_detail_id <=", value, "expenditureDetailId");
            return (Criteria) this;
        }

        public Criteria andExpenditureDetailIdIn(List<Integer> values) {
            addCriterion("expenditure_detail_id in", values, "expenditureDetailId");
            return (Criteria) this;
        }

        public Criteria andExpenditureDetailIdNotIn(List<Integer> values) {
            addCriterion("expenditure_detail_id not in", values, "expenditureDetailId");
            return (Criteria) this;
        }

        public Criteria andExpenditureDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("expenditure_detail_id between", value1, value2, "expenditureDetailId");
            return (Criteria) this;
        }

        public Criteria andExpenditureDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("expenditure_detail_id not between", value1, value2, "expenditureDetailId");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Float value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Float value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Float value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Float value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Float value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Float> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Float> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Float value1, Float value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Float value1, Float value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andProveImageIsNull() {
            addCriterion("prove_image is null");
            return (Criteria) this;
        }

        public Criteria andProveImageIsNotNull() {
            addCriterion("prove_image is not null");
            return (Criteria) this;
        }

        public Criteria andProveImageEqualTo(String value) {
            addCriterion("prove_image =", value, "proveImage");
            return (Criteria) this;
        }

        public Criteria andProveImageNotEqualTo(String value) {
            addCriterion("prove_image <>", value, "proveImage");
            return (Criteria) this;
        }

        public Criteria andProveImageGreaterThan(String value) {
            addCriterion("prove_image >", value, "proveImage");
            return (Criteria) this;
        }

        public Criteria andProveImageGreaterThanOrEqualTo(String value) {
            addCriterion("prove_image >=", value, "proveImage");
            return (Criteria) this;
        }

        public Criteria andProveImageLessThan(String value) {
            addCriterion("prove_image <", value, "proveImage");
            return (Criteria) this;
        }

        public Criteria andProveImageLessThanOrEqualTo(String value) {
            addCriterion("prove_image <=", value, "proveImage");
            return (Criteria) this;
        }

        public Criteria andProveImageLike(String value) {
            addCriterion("prove_image like", value, "proveImage");
            return (Criteria) this;
        }

        public Criteria andProveImageNotLike(String value) {
            addCriterion("prove_image not like", value, "proveImage");
            return (Criteria) this;
        }

        public Criteria andProveImageIn(List<String> values) {
            addCriterion("prove_image in", values, "proveImage");
            return (Criteria) this;
        }

        public Criteria andProveImageNotIn(List<String> values) {
            addCriterion("prove_image not in", values, "proveImage");
            return (Criteria) this;
        }

        public Criteria andProveImageBetween(String value1, String value2) {
            addCriterion("prove_image between", value1, value2, "proveImage");
            return (Criteria) this;
        }

        public Criteria andProveImageNotBetween(String value1, String value2) {
            addCriterion("prove_image not between", value1, value2, "proveImage");
            return (Criteria) this;
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

        public Criteria andExpenditureIdNotEqualTo(Integer value) {
            addCriterion("expenditure_id <>", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdGreaterThan(Integer value) {
            addCriterion("expenditure_id >", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("expenditure_id >=", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdLessThan(Integer value) {
            addCriterion("expenditure_id <", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdLessThanOrEqualTo(Integer value) {
            addCriterion("expenditure_id <=", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdIn(List<Integer> values) {
            addCriterion("expenditure_id in", values, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdNotIn(List<Integer> values) {
            addCriterion("expenditure_id not in", values, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdBetween(Integer value1, Integer value2) {
            addCriterion("expenditure_id between", value1, value2, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdNotBetween(Integer value1, Integer value2) {
            addCriterion("expenditure_id not between", value1, value2, "expenditureId");
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