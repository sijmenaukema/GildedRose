package com.products;

import lombok.Getter;
import com.commons.ProductType;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    //cheated with this
    @Getter
    private ProductType productType;
    
    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.productType = ProductType.COMMON;
    }
    
    public Item(String name, int sellIn, int quality, ProductType productType) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.productType = productType;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
