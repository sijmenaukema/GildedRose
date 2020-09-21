package com.products;

public class AgedBrie implements ItemModification, ItemValidation {
	
	private AgedBrie(){}
	
	public static Item updateItem(Item item) {
		
		ItemModification.decreaseSellDate(item);
		item = ItemValidation.isItemExpired(item) ? ItemModification.increaseQuality(item,2) : ItemModification.increaseQuality(item);
		ItemModification.checkMaxValue(item);
		return item;
	}
}
