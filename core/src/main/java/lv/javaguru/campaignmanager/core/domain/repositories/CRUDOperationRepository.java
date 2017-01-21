package lv.javaguru.campaignmanager.core.domain.repositories;

import java.util.Optional;

public interface CRUDOperationRepository<E, K> {

    void create(E entity);

    Optional<E> getById(K key);

    E getRequired(K key);

    void update(E entity);

    void delete(E entity);

}
