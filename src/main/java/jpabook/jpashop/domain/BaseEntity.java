package jpabook.jpashop.domain;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BaseEntity {
// 공통적으로 자주쓰이는 구문을 따로뺴서 entity로 만들어서 상속함
    //extends 클래스명
    @Column(name = "ISERT_MEMBER")
    private String createdBy;
    private LocalDate createdDate;

    @Column(name = "UPDATE_MEMBER")
    private String lastmodifiedBy;
    private LocalDateTime lastModifiedDate;


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastmodifiedBy() {
        return lastmodifiedBy;
    }

    public void setLastmodifiedBy(String lastmodifiedBy) {
        this.lastmodifiedBy = lastmodifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
