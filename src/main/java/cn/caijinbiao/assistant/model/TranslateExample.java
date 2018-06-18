package cn.caijinbiao.assistant.model;

import java.util.ArrayList;
import java.util.List;

public class TranslateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TranslateExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("f_id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("f_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("f_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("f_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("f_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("f_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("f_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("f_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("f_id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("f_id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("f_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("f_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("f_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("f_id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("f_source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("f_source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("f_source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("f_source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("f_source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("f_source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("f_source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("f_source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("f_source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("f_source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("f_source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("f_source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("f_source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("f_source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andTargetIsNull() {
            addCriterion("f_target is null");
            return (Criteria) this;
        }

        public Criteria andTargetIsNotNull() {
            addCriterion("f_target is not null");
            return (Criteria) this;
        }

        public Criteria andTargetEqualTo(String value) {
            addCriterion("f_target =", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotEqualTo(String value) {
            addCriterion("f_target <>", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThan(String value) {
            addCriterion("f_target >", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThanOrEqualTo(String value) {
            addCriterion("f_target >=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThan(String value) {
            addCriterion("f_target <", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThanOrEqualTo(String value) {
            addCriterion("f_target <=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLike(String value) {
            addCriterion("f_target like", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotLike(String value) {
            addCriterion("f_target not like", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetIn(List<String> values) {
            addCriterion("f_target in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotIn(List<String> values) {
            addCriterion("f_target not in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetBetween(String value1, String value2) {
            addCriterion("f_target between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotBetween(String value1, String value2) {
            addCriterion("f_target not between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("f_type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("f_type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("f_type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("f_type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("f_type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("f_type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("f_type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("f_type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("f_type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("f_type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("f_type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("f_type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("f_type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("f_type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andIspIsNull() {
            addCriterion("f_isp is null");
            return (Criteria) this;
        }

        public Criteria andIspIsNotNull() {
            addCriterion("f_isp is not null");
            return (Criteria) this;
        }

        public Criteria andIspEqualTo(String value) {
            addCriterion("f_isp =", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspNotEqualTo(String value) {
            addCriterion("f_isp <>", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspGreaterThan(String value) {
            addCriterion("f_isp >", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspGreaterThanOrEqualTo(String value) {
            addCriterion("f_isp >=", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspLessThan(String value) {
            addCriterion("f_isp <", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspLessThanOrEqualTo(String value) {
            addCriterion("f_isp <=", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspLike(String value) {
            addCriterion("f_isp like", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspNotLike(String value) {
            addCriterion("f_isp not like", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspIn(List<String> values) {
            addCriterion("f_isp in", values, "isp");
            return (Criteria) this;
        }

        public Criteria andIspNotIn(List<String> values) {
            addCriterion("f_isp not in", values, "isp");
            return (Criteria) this;
        }

        public Criteria andIspBetween(String value1, String value2) {
            addCriterion("f_isp between", value1, value2, "isp");
            return (Criteria) this;
        }

        public Criteria andIspNotBetween(String value1, String value2) {
            addCriterion("f_isp not between", value1, value2, "isp");
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