package com.products;

import com.gildedrose.Item;
import com.gildedrose.ItemValidation;

public class CommonItem extends ItemValidation {
	
	public static Item updateItem(Item item) {
	
		if(isCommonItem(item.name) ) {
			decreaseSellDate(item);
			// conjured items lose quality twice as fast
			if(!isItemExpired(item.sellIn)  && isConjuredItem(item.name) ) {
				decreaseQuality(item, 2);
			}
			else if(!isItemExpired(item.sellIn) && !isConjuredItem(item.name) ) {
				decreaseQuality(item);
			}
			else if(isItemExpired(item.sellIn) && !isConjuredItem(item.name) ) {
				decreaseQuality(item, 2);
			}
			else if(isItemExpired(item.sellIn) && isConjuredItem(item.name) ) {
				decreaseQuality(item, 4);
			}
		}
		return item;
	}
}
