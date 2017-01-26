package lv.javaguru.campaignmanager.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

import static com.google.common.base.Preconditions.checkState;

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

    @ManyToOne
    @JoinColumn(name = "group_id")
    private CampaignGroup campaignGroup;

    @Column(name = "start_date")
    private Date startDate = new Date();

    @Column(name = "end_date")
    private Date endDate = new Date();


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

    public CampaignGroup getCampaignGroup() {
        return campaignGroup;
    }

    public void setCampaignGroup(CampaignGroup campaignGroup) {
        this.campaignGroup = campaignGroup;
    }

    public boolean hasGroup() {
        return campaignGroup != null;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void activate() {
        checkState(isStateChangeAllowed(CampaignState.ACTIVE),
                "State Transition to ACTIVE not allowed");
        this.state = CampaignState.ACTIVE;
    }

    public void deactivate() {
        checkState(isStateChangeAllowed(CampaignState.NOT_ACTIVE),
                "State Transition to NOT_ACTIVE not allowed");
        this.state = CampaignState.NOT_ACTIVE;
    }

    public void close() {
        checkState(isStateChangeAllowed(CampaignState.CLOSED),
                "State Transition to CLOSED not allowed");
        this.state = CampaignState.CLOSED;
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

    public boolean isStateChangeAllowed(CampaignState newState) {
        return state.isTransitionAllowed(newState);
    }

}
