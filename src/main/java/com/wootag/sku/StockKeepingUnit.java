package com.wootag.sku;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;

@Table(value = "skus")
public class StockKeepingUnit implements Comparable<StockKeepingUnit> {
    @PrimaryKeyColumn(name = "storeId", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private String storeId;
    @PrimaryKeyColumn(name = "skuId", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String skuId;
    @Column(value = "productName")
    private String productName;
    @Column(value = "storeName")
    private String storeName;
    @Column(value = "cart")
    private String cart;
    @Column(value = "city")
    private String city;
    @Column(value = "state")
    private String state;
    @Column(value = "country")
    private String country;
    @Column(value = "currency")
    private String currency;
    @Column(value = "price")
    private BigDecimal price;
    @Column(value = "stocks")
    private Integer stocks;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStocks() {
        return stocks;
    }

    public void setStocks(Integer stocks) {
        this.stocks = stocks;
    }

    @Override
    public int compareTo(StockKeepingUnit stockKeepingUnit) {
        return this.getPrice().compareTo(stockKeepingUnit.getPrice());
    }
}