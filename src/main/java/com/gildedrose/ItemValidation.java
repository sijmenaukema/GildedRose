package com.gildedrose;

import com.commons.Utils;

public class ItemValidation extends ItemModification implements Utils{
	   
	public static boolean isConjuredItem(String name) {
    	return (name.contains(CONJURED) ) ? true : false;
    }
    
    public static boolean isCommonItem(String name) {
    	return (!name.equals(AGED_BRIE) && !name.equals(BACKSTAGEPASSES) && !name.equals(SULFURAS) ) ? true : false;
    }
    
    public static boolean isItemExpired(int sellIn) {
    	return (sellIn < MIN_QUALITY) ? true : false;
    }
    
    public static boolean isQualityValid(Item item) {
    	if( item.name != SULFURAS  ) {
    		return (item.quality >= MIN_QUALITY && item.quality <= MAX_QUALITY ) ? true : false;
    	} else { //added to create easy access to requirement change
    		item.quality = LEGENDARY_QUALITY;
    	}
    	return true;
    }
}
