package lv.javaguru.campaignmanager.core.database;

import lv.javaguru.campaignmanager.core.CoreApplicationTest;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

@Ignore
public abstract class DatabaseHibernateTest extends CoreApplicationTest {

    @Autowired
    protected SessionFactory sessionFactory;

    @Autowired
    protected CampaignGroupDAO campaignGroupDAO;

}
