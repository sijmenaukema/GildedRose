package com.products;

public class CommonItem implements ItemModification, ItemValidation {
	
	private CommonItem(){}
	
	public static Item updateItem(Item item) {
	
		if(ItemValidation.isCommonItem(item) ) {
			ItemModification.decreaseSellDate(item);
			// conjured items lose quality twice as fast
			if( !ItemValidation.isItemExpired(item)  && ItemValidation.isConjuredItem(item) || (ItemValidation.isItemExpired(item) && !ItemValidation.isConjuredItem(item) ) ) {
				ItemModification.decreaseQuality(item, 2);
				ItemModification.checkMinValue(item);
			}
			else if(!ItemValidation.isItemExpired(item) && !ItemValidation.isConjuredItem(item) ) {
				ItemModification.decreaseQuality(item);
				ItemModification.checkMinValue(item);
			}

			else if(ItemValidation.isItemExpired(item) && ItemValidation.isConjuredItem(item) ) {
				ItemModification.decreaseQuality(item, 4);
				ItemModification.checkMinValue(item);
			}
		}
		return item;
	}
}
