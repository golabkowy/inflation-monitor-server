package com.inflationmonitor.inflationmonitorserver.data.repositories;

import com.inflationmonitor.inflationmonitorserver.data.entities.ShopType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShopTypeRepository extends CrudRepository<ShopType, Long> {
    @Override
    List<ShopType> findAll();
}
