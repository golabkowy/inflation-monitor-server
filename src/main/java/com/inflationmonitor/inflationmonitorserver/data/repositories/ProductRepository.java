package com.inflationmonitor.inflationmonitorserver.data.repositories;

import com.inflationmonitor.inflationmonitorserver.data.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    Iterable<Product> findAll();

    @Override
    <S extends Product> S save(S entity);

    @Query(value = "SELECT * FROM Product", nativeQuery = true)
    Iterable<Product> findAllCustom();
}
