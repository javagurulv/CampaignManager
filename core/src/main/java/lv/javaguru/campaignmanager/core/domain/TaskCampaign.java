package lv.javaguru.campaignmanager.core.domain;

import javax.persistence.*;

@Entity
@Table(name="task_campaigns")
public class TaskCampaign extends BaseEntity {

    @Id
    @Column(name="id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Campaign campaign;


    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

}
