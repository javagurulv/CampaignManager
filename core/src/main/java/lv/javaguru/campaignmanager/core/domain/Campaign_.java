package lv.javaguru.campaignmanager.core.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Campaign.class)
public class Campaign_ {

    public static volatile SingularAttribute<Campaign, Long> id;
    public static volatile SingularAttribute<Campaign, String> title;
    public static volatile SingularAttribute<Campaign, CampaignState> state;

}
