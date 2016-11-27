package lv.javaguru.campaignmanager.core.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

@Entity
@Table(name = "campaigns")
public class Campaign extends BaseEntity {

    @Id
    @GeneratedValue(generator = "campaign_seq",
                    strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "campaign_seq",
                       sequenceName = "campaign_seq",
                       allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private CampaignState state;


    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CampaignState getState() {
        return state;
    }

    public void setState(CampaignState state) {
        this.state = state;
    }

    public boolean isActive() {
        return state == CampaignState.ACTIVE;
    }

    public boolean isNotActive() {
        return state == CampaignState.NOT_ACTIVE;
    }

    public boolean isClosed() {
        return state == CampaignState.CLOSED;
    }

}
