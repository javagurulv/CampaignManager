package lv.javaguru.campaignmanager.core.database;

import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import lv.javaguru.campaignmanager.core.domain.metamodel.CampaignGroupAttributes;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class CampaignGroupDAOImpl
        extends CRUDOperationDAOImpl<CampaignGroup, Long>
        implements CampaignGroupDAO {

    @Override
    public Optional<CampaignGroup> findByTitle(String title) {
        CampaignGroup campaignGroup = (CampaignGroup) getCurrentSession()
                .createCriteria(CampaignGroup.class)
                .add(Restrictions.eq(CampaignGroupAttributes.title(), title))
                .uniqueResult();
        return Optional.ofNullable(campaignGroup);
    }

}
