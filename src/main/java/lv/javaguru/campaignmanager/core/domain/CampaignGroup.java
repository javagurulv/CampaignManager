package lv.javaguru.campaignmanager.core.domain;

import javax.persistence.*;

@Entity
@Table(name="campaign_groups")
public class CampaignGroup extends BaseEntity {

    @Id
    @GeneratedValue(generator = "campaign_group_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "campaign_group_seq", sequenceName = "campaign_group_seq", allocationSize = 1)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="title", nullable = false)
    private String title;


    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
