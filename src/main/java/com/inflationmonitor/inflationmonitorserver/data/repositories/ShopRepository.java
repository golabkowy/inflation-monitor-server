package com.inflationmonitor.inflationmonitorserver.data.repositories;

import com.inflationmonitor.inflationmonitorserver.data.entities.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {
    @Override
    <S extends Shop> S save(S entity);

    @Override
    List<Shop> findAll();

    @Override
    Iterable<Shop> findAllById(Iterable<Long> longs);
}
