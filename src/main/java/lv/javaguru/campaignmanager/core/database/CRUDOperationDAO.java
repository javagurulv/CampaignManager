package lv.javaguru.campaignmanager.core.database;

import java.util.Optional;

public interface CRUDOperationDAO<E, K> {

    void create(E entity);

    Optional<E> getById(K key);

    E getRequired(K key);

    void update(E entity);

    void delete(E entity);

}