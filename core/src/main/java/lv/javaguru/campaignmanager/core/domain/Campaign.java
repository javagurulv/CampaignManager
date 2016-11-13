package lv.javaguru.campaignmanager.core.domain;

import javax.persistence.*;

@Entity
@Table(name="campaigns")
public class Campaign extends BaseEntity {

    @Id
    @GeneratedValue(generator = "campaign_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "campaign_seq", sequenceName = "campaign_seq", allocationSize = 1)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="title", nullable = false, unique = true)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name="state", nullable = false)
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

}
