package com.products;

import com.commons.Constants;

public class BackstagePasses implements ItemModification, ItemValidation{
	
	private BackstagePasses(){}

	public static Item updateItem(Item item) {
		
		item = ItemModification.decreaseSellDate(item);
		
		if(!ItemValidation.isItemExpired(item)) {
			if( item.sellIn <= 5) {
				ItemModification.increaseQuality(item, 3);
				ItemModification.checkMaxValue(item);
			}
			else if( item.sellIn <= 10) {
				ItemModification.increaseQuality(item, 2);
				ItemModification.checkMaxValue(item);
			}
			else {
				ItemModification.increaseQuality(item);
				ItemModification.checkMaxValue(item);
			} 
		} else {
			item.quality = Constants.getMIN_QUALITY();
		}
		return item;
	}
}
