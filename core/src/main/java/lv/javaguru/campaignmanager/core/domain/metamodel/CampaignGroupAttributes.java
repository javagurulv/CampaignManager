package lv.javaguru.campaignmanager.core.domain.metamodel;

import lv.javaguru.campaignmanager.core.domain.CampaignGroup;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CampaignGroup.class)
public class CampaignGroupAttributes {

    public static volatile SingularAttribute<CampaignGroup, Long> id;
    public static volatile SingularAttribute<CampaignGroup, String> title;


    public static String id() {
        return id.getName();
    }

    public static String title() {
        return title.getName();
    }

}
