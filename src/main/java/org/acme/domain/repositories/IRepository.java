package org.acme.domain.repositories;

import java.util.List;
import java.util.Optional;

public interface IRepository<T, ID> {

    T create(T t);
    T update(T t);
    void delete(ID id);
    Optional<T> findById(ID id);
    List<T> findByExample(T t);
    List<T> findAll();

}