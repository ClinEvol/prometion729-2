package com.ujiuye.prometion.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaluateExample() {
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

        public Criteria andEvaidIsNull() {
            addCriterion("evaid is null");
            return (Criteria) this;
        }

        public Criteria andEvaidIsNotNull() {
            addCriterion("evaid is not null");
            return (Criteria) this;
        }

        public Criteria andEvaidEqualTo(Integer value) {
            addCriterion("evaid =", value, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidNotEqualTo(Integer value) {
            addCriterion("evaid <>", value, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidGreaterThan(Integer value) {
            addCriterion("evaid >", value, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaid >=", value, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidLessThan(Integer value) {
            addCriterion("evaid <", value, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidLessThanOrEqualTo(Integer value) {
            addCriterion("evaid <=", value, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidIn(List<Integer> values) {
            addCriterion("evaid in", values, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidNotIn(List<Integer> values) {
            addCriterion("evaid not in", values, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidBetween(Integer value1, Integer value2) {
            addCriterion("evaid between", value1, value2, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidNotBetween(Integer value1, Integer value2) {
            addCriterion("evaid not between", value1, value2, "evaid");
            return (Criteria) this;
        }

        public Criteria andForumFkIsNull() {
            addCriterion("forum_fk is null");
            return (Criteria) this;
        }

        public Criteria andForumFkIsNotNull() {
            addCriterion("forum_fk is not null");
            return (Criteria) this;
        }

        public Criteria andForumFkEqualTo(Integer value) {
            addCriterion("forum_fk =", value, "forumFk");
            return (Criteria) this;
        }

        public Criteria andForumFkNotEqualTo(Integer value) {
            addCriterion("forum_fk <>", value, "forumFk");
            return (Criteria) this;
        }

        public Criteria andForumFkGreaterThan(Integer value) {
            addCriterion("forum_fk >", value, "forumFk");
            return (Criteria) this;
        }

        public Criteria andForumFkGreaterThanOrEqualTo(Integer value) {
            addCriterion("forum_fk >=", value, "forumFk");
            return (Criteria) this;
        }

        public Criteria andForumFkLessThan(Integer value) {
            addCriterion("forum_fk <", value, "forumFk");
            return (Criteria) this;
        }

        public Criteria andForumFkLessThanOrEqualTo(Integer value) {
            addCriterion("forum_fk <=", value, "forumFk");
            return (Criteria) this;
        }

        public Criteria andForumFkIn(List<Integer> values) {
            addCriterion("forum_fk in", values, "forumFk");
            return (Criteria) this;
        }

        public Criteria andForumFkNotIn(List<Integer> values) {
            addCriterion("forum_fk not in", values, "forumFk");
            return (Criteria) this;
        }

        public Criteria andForumFkBetween(Integer value1, Integer value2) {
            addCriterion("forum_fk between", value1, value2, "forumFk");
            return (Criteria) this;
        }

        public Criteria andForumFkNotBetween(Integer value1, Integer value2) {
            addCriterion("forum_fk not between", value1, value2, "forumFk");
            return (Criteria) this;
        }

        public Criteria andEmpFk4IsNull() {
            addCriterion("emp_fk4 is null");
            return (Criteria) this;
        }

        public Criteria andEmpFk4IsNotNull() {
            addCriterion("emp_fk4 is not null");
            return (Criteria) this;
        }

        public Criteria andEmpFk4EqualTo(Integer value) {
            addCriterion("emp_fk4 =", value, "empFk4");
            return (Criteria) this;
        }

        public Criteria andEmpFk4NotEqualTo(Integer value) {
            addCriterion("emp_fk4 <>", value, "empFk4");
            return (Criteria) this;
        }

        public Criteria andEmpFk4GreaterThan(Integer value) {
            addCriterion("emp_fk4 >", value, "empFk4");
            return (Criteria) this;
        }

        public Criteria andEmpFk4GreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_fk4 >=", value, "empFk4");
            return (Criteria) this;
        }

        public Criteria andEmpFk4LessThan(Integer value) {
            addCriterion("emp_fk4 <", value, "empFk4");
            return (Criteria) this;
        }

        public Criteria andEmpFk4LessThanOrEqualTo(Integer value) {
            addCriterion("emp_fk4 <=", value, "empFk4");
            return (Criteria) this;
        }

        public Criteria andEmpFk4In(List<Integer> values) {
            addCriterion("emp_fk4 in", values, "empFk4");
            return (Criteria) this;
        }

        public Criteria andEmpFk4NotIn(List<Integer> values) {
            addCriterion("emp_fk4 not in", values, "empFk4");
            return (Criteria) this;
        }

        public Criteria andEmpFk4Between(Integer value1, Integer value2) {
            addCriterion("emp_fk4 between", value1, value2, "empFk4");
            return (Criteria) this;
        }

        public Criteria andEmpFk4NotBetween(Integer value1, Integer value2) {
            addCriterion("emp_fk4 not between", value1, value2, "empFk4");
            return (Criteria) this;
        }

        public Criteria andEvaidFkIsNull() {
            addCriterion("evaid_fk is null");
            return (Criteria) this;
        }

        public Criteria andEvaidFkIsNotNull() {
            addCriterion("evaid_fk is not null");
            return (Criteria) this;
        }

        public Criteria andEvaidFkEqualTo(Integer value) {
            addCriterion("evaid_fk =", value, "evaidFk");
            return (Criteria) this;
        }

        public Criteria andEvaidFkNotEqualTo(Integer value) {
            addCriterion("evaid_fk <>", value, "evaidFk");
            return (Criteria) this;
        }

        public Criteria andEvaidFkGreaterThan(Integer value) {
            addCriterion("evaid_fk >", value, "evaidFk");
            return (Criteria) this;
        }

        public Criteria andEvaidFkGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaid_fk >=", value, "evaidFk");
            return (Criteria) this;
        }

        public Criteria andEvaidFkLessThan(Integer value) {
            addCriterion("evaid_fk <", value, "evaidFk");
            return (Criteria) this;
        }

        public Criteria andEvaidFkLessThanOrEqualTo(Integer value) {
            addCriterion("evaid_fk <=", value, "evaidFk");
            return (Criteria) this;
        }

        public Criteria andEvaidFkIn(List<Integer> values) {
            addCriterion("evaid_fk in", values, "evaidFk");
            return (Criteria) this;
        }

        public Criteria andEvaidFkNotIn(List<Integer> values) {
            addCriterion("evaid_fk not in", values, "evaidFk");
            return (Criteria) this;
        }

        public Criteria andEvaidFkBetween(Integer value1, Integer value2) {
            addCriterion("evaid_fk between", value1, value2, "evaidFk");
            return (Criteria) this;
        }

        public Criteria andEvaidFkNotBetween(Integer value1, Integer value2) {
            addCriterion("evaid_fk not between", value1, value2, "evaidFk");
            return (Criteria) this;
        }

        public Criteria andEvacontentIsNull() {
            addCriterion("evacontent is null");
            return (Criteria) this;
        }

        public Criteria andEvacontentIsNotNull() {
            addCriterion("evacontent is not null");
            return (Criteria) this;
        }

        public Criteria andEvacontentEqualTo(String value) {
            addCriterion("evacontent =", value, "evacontent");
            return (Criteria) this;
        }

        public Criteria andEvacontentNotEqualTo(String value) {
            addCriterion("evacontent <>", value, "evacontent");
            return (Criteria) this;
        }

        public Criteria andEvacontentGreaterThan(String value) {
            addCriterion("evacontent >", value, "evacontent");
            return (Criteria) this;
        }

        public Criteria andEvacontentGreaterThanOrEqualTo(String value) {
            addCriterion("evacontent >=", value, "evacontent");
            return (Criteria) this;
        }

        public Criteria andEvacontentLessThan(String value) {
            addCriterion("evacontent <", value, "evacontent");
            return (Criteria) this;
        }

        public Criteria andEvacontentLessThanOrEqualTo(String value) {
            addCriterion("evacontent <=", value, "evacontent");
            return (Criteria) this;
        }

        public Criteria andEvacontentLike(String value) {
            addCriterion("evacontent like", value, "evacontent");
            return (Criteria) this;
        }

        public Criteria andEvacontentNotLike(String value) {
            addCriterion("evacontent not like", value, "evacontent");
            return (Criteria) this;
        }

        public Criteria andEvacontentIn(List<String> values) {
            addCriterion("evacontent in", values, "evacontent");
            return (Criteria) this;
        }

        public Criteria andEvacontentNotIn(List<String> values) {
            addCriterion("evacontent not in", values, "evacontent");
            return (Criteria) this;
        }

        public Criteria andEvacontentBetween(String value1, String value2) {
            addCriterion("evacontent between", value1, value2, "evacontent");
            return (Criteria) this;
        }

        public Criteria andEvacontentNotBetween(String value1, String value2) {
            addCriterion("evacontent not between", value1, value2, "evacontent");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andEvatimeIsNull() {
            addCriterion("evatime is null");
            return (Criteria) this;
        }

        public Criteria andEvatimeIsNotNull() {
            addCriterion("evatime is not null");
            return (Criteria) this;
        }

        public Criteria andEvatimeEqualTo(Date value) {
            addCriterion("evatime =", value, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeNotEqualTo(Date value) {
            addCriterion("evatime <>", value, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeGreaterThan(Date value) {
            addCriterion("evatime >", value, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("evatime >=", value, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeLessThan(Date value) {
            addCriterion("evatime <", value, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeLessThanOrEqualTo(Date value) {
            addCriterion("evatime <=", value, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeIn(List<Date> values) {
            addCriterion("evatime in", values, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeNotIn(List<Date> values) {
            addCriterion("evatime not in", values, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeBetween(Date value1, Date value2) {
            addCriterion("evatime between", value1, value2, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeNotBetween(Date value1, Date value2) {
            addCriterion("evatime not between", value1, value2, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvastatusIsNull() {
            addCriterion("evastatus is null");
            return (Criteria) this;
        }

        public Criteria andEvastatusIsNotNull() {
            addCriterion("evastatus is not null");
            return (Criteria) this;
        }

        public Criteria andEvastatusEqualTo(Integer value) {
            addCriterion("evastatus =", value, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusNotEqualTo(Integer value) {
            addCriterion("evastatus <>", value, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusGreaterThan(Integer value) {
            addCriterion("evastatus >", value, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("evastatus >=", value, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusLessThan(Integer value) {
            addCriterion("evastatus <", value, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusLessThanOrEqualTo(Integer value) {
            addCriterion("evastatus <=", value, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusIn(List<Integer> values) {
            addCriterion("evastatus in", values, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusNotIn(List<Integer> values) {
            addCriterion("evastatus not in", values, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusBetween(Integer value1, Integer value2) {
            addCriterion("evastatus between", value1, value2, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusNotBetween(Integer value1, Integer value2) {
            addCriterion("evastatus not between", value1, value2, "evastatus");
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