package com.oyo.cchdatamigration.cchdatamigration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CchList {
    @JsonProperty("callcentre_organization_structures")
    List<Cch> cchList;

    public CchList() {
    }

    public List<Cch> getCchList() {
        return cchList;
    }

    public void setCchList(List<Cch> cchList) {
        this.cchList = cchList;
    }
}
