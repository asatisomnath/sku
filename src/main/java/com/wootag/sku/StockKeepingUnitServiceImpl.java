package com.wootag.sku;

import java.util.*;

public class StockKeepingUnitServiceImpl implements StockKeepingUnitService {

    private StockKeepingUnitRepository stockKeepingUnitRepository;

    public StockKeepingUnitServiceImpl(StockKeepingUnitRepository stockKeepingUnitRepository){
        this.stockKeepingUnitRepository = stockKeepingUnitRepository;
    }

    @Override
    public List<StockKeepingUnit> getStockKeepingUnitsByLowestPrice(String skuId, int n) {
        List<StockKeepingUnit> stockKeepingUnits = new ArrayList<>();

        PriorityQueue<StockKeepingUnit> stockKeepingUnitHeap = new PriorityQueue<>(Collections.reverseOrder());

        stockKeepingUnitRepository.findByskuId(skuId).forEach(e -> {

            if(stockKeepingUnitHeap.isEmpty() || (!stockKeepingUnitHeap.isEmpty() && stockKeepingUnitHeap.size()<n)){
                stockKeepingUnitHeap.add(e);
            } else {
                StockKeepingUnit stockKeepingUnit = stockKeepingUnitHeap.peek();
                if(stockKeepingUnit.getPrice().compareTo(e.getPrice())==1){
                    stockKeepingUnitHeap.poll();
                    stockKeepingUnitHeap.add(e);
                }
            }
        });

        for(int i=0;i<n && stockKeepingUnitHeap.peek()!=null;i++){
            stockKeepingUnits.add(0, stockKeepingUnitHeap.poll());
        }

        return stockKeepingUnits;
    }
}
