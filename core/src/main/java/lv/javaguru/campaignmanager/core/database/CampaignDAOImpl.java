package lv.javaguru.campaignmanager.core.database;

import lv.javaguru.campaignmanager.core.domain.Campaign;
import lv.javaguru.campaignmanager.core.domain.Campaign_;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class CampaignDAOImpl
        extends CRUDOperationDAOImpl<Campaign, Long>
        implements CampaignDAO {

    @Override
    public Optional<Campaign> findByTitle(String title) {
        Campaign campaign = (Campaign) getCurrentSession()
                .createCriteria(Campaign.class)
                .add(Restrictions.eq(Campaign_.title.getName(), title))
                .uniqueResult();
        return Optional.ofNullable(campaign);
    }

}
