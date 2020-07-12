package com.wootag.sku;


import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

public interface StockKeepingUnitRepository extends CassandraRepository<StockKeepingUnit, String> {
    @Query("SELECT*FROM skus WHERE skuId=?0")
    Iterable<StockKeepingUnit> findByskuId(String skuId);
}
