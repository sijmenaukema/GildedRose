package com.products;

import com.gildedrose.Item;
import com.gildedrose.ItemModification;
import com.gildedrose.ItemValidation;

public class AgedBrie extends ItemValidation {
	
	public static Item updateItem(Item item) {
		
		ItemModification.decreaseSellDate(item);
		return (isItemExpired(item.sellIn)) ? increaseQuality(item,2) : increaseQuality(item);
	}
}
