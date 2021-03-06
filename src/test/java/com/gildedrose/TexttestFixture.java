package com.gildedrose;

import java.util.Scanner;

import com.commons.ProductType;
import com.products.Item;

public class TexttestFixture {
    public static void main(String[] args) throws Exception {
        System.out.println("OMGHAI!");

        Scanner scanner = new Scanner(System.in);
        
        Item[] items = new Item[] {
        		 new Item("+5 Dexterity Vest", 10, 20), //
                 new Item("Aged Brie", 2, 0, ProductType.AGED_BRIE), //
                 new Item("Elixir of the Mongoose", 5, 7), //
                 new Item("Sulfuras, Hand of Ragnaros", 0, 80, ProductType.SULFURAS), //
                 new Item("Sulfuras, Hand of Ragnaros", -1, 80, ProductType.SULFURAS),
                 new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20, ProductType.BACKSTAGEPASSES),
                 new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49, ProductType.BACKSTAGEPASSES),
                 new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49, ProductType.BACKSTAGEPASSES),
                 new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);
        
        System.out.println("How many days for inventory management ");
        try {
        	int days = scanner.nextInt();
        	if(days < 0 ) {
				throw new IllegalArgumentException("Days need to have a positive value");
        	}   	
	        for (int i = 0; i < days; i++) {
	            System.out.println("-------- day " + i + " --------");
	            System.out.println("name, sellIn, quality");
	            for (Item item : items) {
	                System.out.println(item);
	            }
	            System.out.println();
	            app.updateQuality();
	        }
        } catch(Exception e) {
        	e.printStackTrace();
        	
        } finally {
        	scanner.close();
        }
    }
}

