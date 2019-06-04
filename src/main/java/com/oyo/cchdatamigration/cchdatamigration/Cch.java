package com.oyo.cchdatamigration.cchdatamigration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cch {

    @JsonProperty("id")
    private long id;
    @JsonProperty("user_profile_id")
    private long user_profile_id;
    @JsonProperty("level_1")
    private String level_1;
    @JsonProperty("level_2")
    private String level_2;
    @JsonProperty("level_3")
    private String level_3;
    @JsonProperty("level_4")
    private String level_4;
    @JsonProperty("created_by_id")
    private long created_by_id;
    @JsonProperty("active")
    private boolean active;
    @JsonProperty("created_at")
    private String created_at;
    @JsonProperty("updated_at")
    private String updated_at;

    public Cch() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_profile_id() {
        return user_profile_id;
    }

    public void setUser_profile_id(long user_profile_id) {
        this.user_profile_id = user_profile_id;
    }

    public String getLevel_1() {
        return level_1;
    }

    public void setLevel_1(String level_1) {
        this.level_1 = level_1;
    }

    public String getLevel_2() {
        return level_2;
    }

    public void setLevel_2(String level_2) {
        this.level_2 = level_2;
    }

    public String getLevel_3() {
        return level_3;
    }

    public void setLevel_3(String level_3) {
        this.level_3 = level_3;
    }

    public String getLevel_4() {
        return level_4;
    }

    public void setLevel_4(String level_4) {
        this.level_4 = level_4;
    }

    public long getCreated_by_id() {
        return created_by_id;
    }

    public void setCreated_by_id(long created_by_id) {
        this.created_by_id = created_by_id;
    }


    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Cch{" +
                "id=" + id +
                ", user_profile_id=" + user_profile_id +
                ", level_1='" + level_1 + '\'' +
                ", level_2='" + level_2 + '\'' +
                ", level_3='" + level_3 + '\'' +
                ", level_4='" + level_4 + '\'' +
                ", created_by_id=" + created_by_id +
                ", active=" + active +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
