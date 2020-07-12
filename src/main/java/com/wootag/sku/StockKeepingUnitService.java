package com.wootag.sku;

import java.util.List;

public interface StockKeepingUnitService {

    List<StockKeepingUnit> getStockKeepingUnitsByLowestPrice(String skuId, int n);

}
