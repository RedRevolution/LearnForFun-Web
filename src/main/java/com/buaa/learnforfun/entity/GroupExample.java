package com.buaa.learnforfun.entity;

import java.util.ArrayList;
import java.util.List;

public class GroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("group_id like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("group_id not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerIdIsNull() {
            addCriterion("group_owner_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerIdIsNotNull() {
            addCriterion("group_owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerIdEqualTo(String value) {
            addCriterion("group_owner_id =", value, "groupOwnerId");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerIdNotEqualTo(String value) {
            addCriterion("group_owner_id <>", value, "groupOwnerId");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerIdGreaterThan(String value) {
            addCriterion("group_owner_id >", value, "groupOwnerId");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_owner_id >=", value, "groupOwnerId");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerIdLessThan(String value) {
            addCriterion("group_owner_id <", value, "groupOwnerId");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerIdLessThanOrEqualTo(String value) {
            addCriterion("group_owner_id <=", value, "groupOwnerId");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerIdLike(String value) {
            addCriterion("group_owner_id like", value, "groupOwnerId");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerIdNotLike(String value) {
            addCriterion("group_owner_id not like", value, "groupOwnerId");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerIdIn(List<String> values) {
            addCriterion("group_owner_id in", values, "groupOwnerId");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerIdNotIn(List<String> values) {
            addCriterion("group_owner_id not in", values, "groupOwnerId");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerIdBetween(String value1, String value2) {
            addCriterion("group_owner_id between", value1, value2, "groupOwnerId");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerIdNotBetween(String value1, String value2) {
            addCriterion("group_owner_id not between", value1, value2, "groupOwnerId");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerNameIsNull() {
            addCriterion("group_owner_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerNameIsNotNull() {
            addCriterion("group_owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerNameEqualTo(String value) {
            addCriterion("group_owner_name =", value, "groupOwnerName");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerNameNotEqualTo(String value) {
            addCriterion("group_owner_name <>", value, "groupOwnerName");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerNameGreaterThan(String value) {
            addCriterion("group_owner_name >", value, "groupOwnerName");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_owner_name >=", value, "groupOwnerName");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerNameLessThan(String value) {
            addCriterion("group_owner_name <", value, "groupOwnerName");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("group_owner_name <=", value, "groupOwnerName");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerNameLike(String value) {
            addCriterion("group_owner_name like", value, "groupOwnerName");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerNameNotLike(String value) {
            addCriterion("group_owner_name not like", value, "groupOwnerName");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerNameIn(List<String> values) {
            addCriterion("group_owner_name in", values, "groupOwnerName");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerNameNotIn(List<String> values) {
            addCriterion("group_owner_name not in", values, "groupOwnerName");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerNameBetween(String value1, String value2) {
            addCriterion("group_owner_name between", value1, value2, "groupOwnerName");
            return (Criteria) this;
        }

        public Criteria andGroupOwnerNameNotBetween(String value1, String value2) {
            addCriterion("group_owner_name not between", value1, value2, "groupOwnerName");
            return (Criteria) this;
        }

        public Criteria andGroupIntrodIsNull() {
            addCriterion("group_introd is null");
            return (Criteria) this;
        }

        public Criteria andGroupIntrodIsNotNull() {
            addCriterion("group_introd is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIntrodEqualTo(String value) {
            addCriterion("group_introd =", value, "groupIntrod");
            return (Criteria) this;
        }

        public Criteria andGroupIntrodNotEqualTo(String value) {
            addCriterion("group_introd <>", value, "groupIntrod");
            return (Criteria) this;
        }

        public Criteria andGroupIntrodGreaterThan(String value) {
            addCriterion("group_introd >", value, "groupIntrod");
            return (Criteria) this;
        }

        public Criteria andGroupIntrodGreaterThanOrEqualTo(String value) {
            addCriterion("group_introd >=", value, "groupIntrod");
            return (Criteria) this;
        }

        public Criteria andGroupIntrodLessThan(String value) {
            addCriterion("group_introd <", value, "groupIntrod");
            return (Criteria) this;
        }

        public Criteria andGroupIntrodLessThanOrEqualTo(String value) {
            addCriterion("group_introd <=", value, "groupIntrod");
            return (Criteria) this;
        }

        public Criteria andGroupIntrodLike(String value) {
            addCriterion("group_introd like", value, "groupIntrod");
            return (Criteria) this;
        }

        public Criteria andGroupIntrodNotLike(String value) {
            addCriterion("group_introd not like", value, "groupIntrod");
            return (Criteria) this;
        }

        public Criteria andGroupIntrodIn(List<String> values) {
            addCriterion("group_introd in", values, "groupIntrod");
            return (Criteria) this;
        }

        public Criteria andGroupIntrodNotIn(List<String> values) {
            addCriterion("group_introd not in", values, "groupIntrod");
            return (Criteria) this;
        }

        public Criteria andGroupIntrodBetween(String value1, String value2) {
            addCriterion("group_introd between", value1, value2, "groupIntrod");
            return (Criteria) this;
        }

        public Criteria andGroupIntrodNotBetween(String value1, String value2) {
            addCriterion("group_introd not between", value1, value2, "groupIntrod");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIsNull() {
            addCriterion("course_code is null");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIsNotNull() {
            addCriterion("course_code is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCodeEqualTo(String value) {
            addCriterion("course_code =", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotEqualTo(String value) {
            addCriterion("course_code <>", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeGreaterThan(String value) {
            addCriterion("course_code >", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("course_code >=", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLessThan(String value) {
            addCriterion("course_code <", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLessThanOrEqualTo(String value) {
            addCriterion("course_code <=", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLike(String value) {
            addCriterion("course_code like", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotLike(String value) {
            addCriterion("course_code not like", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIn(List<String> values) {
            addCriterion("course_code in", values, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotIn(List<String> values) {
            addCriterion("course_code not in", values, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeBetween(String value1, String value2) {
            addCriterion("course_code between", value1, value2, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotBetween(String value1, String value2) {
            addCriterion("course_code not between", value1, value2, "courseCode");
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