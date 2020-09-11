package com.inflationmonitor.inflationmonitorserver.data.repositories;

import com.inflationmonitor.inflationmonitorserver.data.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//pagination read about PAgeRequest classx ;)
@Repository
//public class ProductRepository implements SimpleJpaRepository<Product, Integer> {
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    Iterable<Product> findAll();

    @Override
    <S extends Product> S save(S entity);
}
