package com.oyo.cchdatamigration.cchdatamigration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    @JsonProperty("userprofileid")
    private long user_profile_id;
    @JsonProperty("parent")
    private long parent_profileId;
    @JsonProperty("empid")
    private long emp;

    public long getEmp() {
        return emp;
    }

    public void setEmp(long emp) {
        this.emp = emp;
    }

    public long getUser_profile_id() {
        return user_profile_id;
    }

    public void setUser_profile_id(long user_profile_id) {
        this.user_profile_id = user_profile_id;
    }

    public long getParent_profileId() {
        return parent_profileId;
    }

    public void setParent_profileId(long parent_profileId) {
        this.parent_profileId = parent_profileId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "user_profile_id=" + user_profile_id +
                ", parent_profileId=" + parent_profileId +
                '}';
    }
}
