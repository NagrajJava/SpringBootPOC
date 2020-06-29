package com.mongo.commons;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseEntity {
	
	@CreatedDate
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private DateTime createdDate;

    @CreatedBy
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String createdBy;

    @LastModifiedDate
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private DateTime updatedDate;

    @LastModifiedBy
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String updateBy;

    @Version
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long version;


    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public DateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(DateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

  
}
