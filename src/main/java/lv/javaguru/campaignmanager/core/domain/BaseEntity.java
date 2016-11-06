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

    @Column(name="created_date")
    private Date createdDate = new Date();


    public Date getCreatedDate() {
        return createdDate;
    }

    public abstract void setId(Long id);

    public abstract Long getId();

}
