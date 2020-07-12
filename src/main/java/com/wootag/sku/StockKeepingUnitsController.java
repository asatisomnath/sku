package com.wootag.sku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StockKeepingUnitsController {

    @Autowired
    private StockKeepingUnitRepository stockKeepingUnitRepository;

    private StockKeepingUnitService stockKeepingUnitService;

    @RequestMapping(value = "/sku",method = RequestMethod.GET)
    @ResponseBody
    public StockKeepingUnit stockKeepingUnits() {
        StockKeepingUnit stockKeepingUnit = new StockKeepingUnit();
        return stockKeepingUnit;
    }
    @RequestMapping(value = "/sku/{skuId}",method = RequestMethod.GET)
    @ResponseBody
    public SearchResponse stockKeepingUnitsBySkuId(@PathVariable String skuId) {
        long startTime = System.currentTimeMillis();
        stockKeepingUnitService = new StockKeepingUnitServiceImpl(stockKeepingUnitRepository);
        List<StockKeepingUnit> stockKeepingUnits = stockKeepingUnitService.getStockKeepingUnitsByLowestPrice(skuId, 2);
        long duration = System.currentTimeMillis() - startTime;
        SearchResponse searchResponse = new SearchResponse(stockKeepingUnits, duration);
        return searchResponse;
    }

}
