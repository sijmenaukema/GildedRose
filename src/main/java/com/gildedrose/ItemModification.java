package com.gildedrose;

import com.commons.Utils;

public class ItemModification implements Utils {
	
	public static Item increaseQuality(Item item) {
		item.quality++ ;
		return checkMaxValue(item);
	}
	
	public static Item increaseQuality(Item item, int amount) {
		item.quality += amount ;
		return checkMaxValue(item);
	}

	public static Item decreaseQuality(Item item) {
		item.quality--;
		return checkMinValue(item);
	}
	
	public static Item decreaseQuality(Item item, int amount) {
		item.quality -= amount;
		return checkMinValue(item);
	}
	
	static Item checkMaxValue(Item item) {
		item.quality = (item.quality > MAX_QUALITY) ? MAX_QUALITY : item.quality;
		return item;
	}
	
	static Item checkMinValue(Item item) {
		item.quality = (item.quality < MIN_QUALITY) ? MIN_QUALITY : item.quality;
		return item;
	}
	
	public static Item decreaseSellDate(Item item) {
		item.sellIn--;
		return item;
	}
}
