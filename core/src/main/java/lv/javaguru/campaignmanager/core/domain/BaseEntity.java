package lv.javaguru.campaignmanager.core.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Version
    private Long version = 0L;

    @Column(name = "created_date", nullable = false)
    private Date createdDate = new Date();

    @Column(name = "updated_date", nullable = true)
    private Date updatedDate;


    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public abstract void setId(Long id);

    public abstract Long getId();

}
