package com.gildedrose;

import com.products.AgedBrie;
import com.products.BackstagePasses;
import com.products.CommonItem;
import com.products.Item;


public class GildedRose{
	
	Item[] items;
  
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items ) {
    	
    	
        	switch(item.getProductType()) {
        	
        		case SULFURAS:
        			//do nothing
    			break;
        			
        		case AGED_BRIE:
        			AgedBrie.updateItem(item);
				break;
				
        		case BACKSTAGEPASSES:
        			BackstagePasses.updateItem(item);
    			break;
    			
        		default: //for all common items
        			CommonItem.updateItem(item);
			}        
    	}
	} 
}

