package com.products;

import com.commons.Constants;

interface ItemModification{

	
	static Item increaseQuality(Item item) {
		item.quality++ ;
		return item;
	}
	
	static Item increaseQuality(Item item, int amount) {
		item.quality += amount ;
		return item;
	}

	static Item decreaseQuality(Item item) {
		item.quality--;
		return item;
	}
	
	static Item decreaseQuality(Item item, int amount) {
		item.quality -= amount;
		return item;
	}
	
	static Item checkMaxValue(Item item) {
		item.quality = (item.quality > Constants.getMAX_QUALITY()) ? Constants.getMAX_QUALITY() : item.quality;
		return item;
	}
	
	static Item checkMinValue(Item item) {
		item.quality = (item.quality < Constants.getMIN_QUALITY()) ? Constants.getMIN_QUALITY() : item.quality;
		return item;
	}
	
	static Item decreaseSellDate(Item item) {
		item.sellIn--;
		return item;
	}
}
