package com.wootag.sku;

import java.util.List;

public class SearchResponse {
    private List<StockKeepingUnit> stockKeepingUnits;
    private Long ttl;

    public SearchResponse(List<StockKeepingUnit> stockKeepingUnits, Long ttl){
        this.stockKeepingUnits =stockKeepingUnits;
        this.ttl = ttl;
    }

    public Long getTtl() {
        return ttl;
    }

    public List<StockKeepingUnit> getStockKeepingUnits(){
        return stockKeepingUnits;
    }
}
