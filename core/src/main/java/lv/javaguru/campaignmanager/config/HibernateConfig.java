package lv.javaguru.campaignmanager.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
@EntityScan(basePackages = "lv.javaguru.campaignmanager.core.domain")
class HibernateConfig {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public SessionFactory getSessionFactory() {
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

}