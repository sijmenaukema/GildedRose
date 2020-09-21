package com.products;

import com.commons.ProductType;
import com.commons.Constants;

interface ItemValidation{
	   
	static boolean isConjuredItem(Item item) {
    	return (item.getProductType().equals(ProductType.CONJURED ) );
    }
    
    static boolean isCommonItem(Item item) {
    	return (!item.getProductType().equals(ProductType.AGED_BRIE) && !item.getProductType().equals(ProductType.BACKSTAGEPASSES) );
    }
    
    static boolean isItemExpired(Item item) {
    	return (item.sellIn < 0 );
    }
    
    static boolean isQualityValid(Item item) {
    	if( !item.getProductType().equals( ProductType.SULFURAS ) ) {
    		return (item.quality >= Constants.getMIN_QUALITY() && item.quality <= Constants.getMAX_QUALITY() );
    	} else { //added to create easy access to requirement change
    		item.quality = Constants.getLEGENDARY_QUALITY();
    	}
    	return true;
    }
}
