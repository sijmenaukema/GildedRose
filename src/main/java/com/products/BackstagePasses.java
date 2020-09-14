package com.products;

import com.gildedrose.Item;
import com.gildedrose.ItemValidation;

public class BackstagePasses extends ItemValidation{
	
	public static Item updateItem(Item item) {
		
		item = decreaseSellDate(item);
		
		if(!isItemExpired(item.sellIn)) {
			if( item.sellIn <= 5) {
				increaseQuality(item, 3);
			}
			else if( item.sellIn <= 10) {
				increaseQuality(item, 2);
			}
			else {
				increaseQuality(item);
			} 
		} else {
			item.quality = MIN_QUALITY;
		}
		return item;
	}
}
