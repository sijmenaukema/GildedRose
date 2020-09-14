package com.gildedrose;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.commons.Utils;

class GildedRoseTest implements Utils{

    @Test
    void commonItemTest() throws Exception {
//    	decrease in quality and sellIn per day
        Item[] items = new Item[] { new Item("Common Item", 20, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertEquals("Common Item", app.items[0].name);
        Assertions.assertEquals(20-1, app.items[0].sellIn);
        Assertions.assertEquals(30-1, app.items[0].quality);

    }
    
    @Test
    void commonExpiredItemTest() throws Exception {
//    	decrease in quality twice as fast
        Item[] items = new Item[] { new Item("Common Item", 0, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertEquals("Common Item", app.items[0].name);
        Assertions.assertEquals(0-1, app.items[0].sellIn);
        Assertions.assertEquals(30-2, app.items[0].quality);

    }
    
    @Test
    void sulfurasTest() throws Exception {
//    	no decrease in quality and sellIn
	    Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 15, 48) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assertions.assertEquals(SULFURAS, app.items[0].name);
	    Assertions.assertEquals(15, app.items[0].sellIn);
	    Assertions.assertEquals(48, app.items[0].quality);

	}
    
    @Test
    void agedBrieTest() throws Exception {
//    	increase in quality as sellIn drops
	    Item[] items = new Item[] { new Item("Aged Brie", 15, 35) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assertions.assertEquals(AGED_BRIE, app.items[0].name);
	    Assertions.assertEquals(15-1, app.items[0].sellIn);
	    Assertions.assertEquals(35+1, app.items[0].quality);

	}
    
    @Test
    void backstagePassesFiveDaysTest() throws Exception {
//    	increase in quality as sellIn drops under 10 and 5 respectively
	    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assertions.assertEquals(BACKSTAGEPASSES, app.items[0].name);
	    Assertions.assertEquals(5-1, app.items[0].sellIn);
	    Assertions.assertEquals(10+3, app.items[0].quality);

	}
    
    @Test
    void backstagePassesTenDaysTest() throws Exception {
//    	increase in quality as sellIn drops under 10 and 5 respectively
	    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assertions.assertEquals(BACKSTAGEPASSES, app.items[0].name);
	    Assertions.assertEquals(10-1, app.items[0].sellIn);
	    Assertions.assertEquals(10+2, app.items[0].quality);

	}
    
    @Test
    void backstagePassesExpiredTest() throws Exception {
//    	increase in quality as sellIn drops under 10 and 5 respectively
	    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 49) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assertions.assertEquals(BACKSTAGEPASSES, app.items[0].name);
	    Assertions.assertEquals(-2, app.items[0].sellIn);
	    Assertions.assertEquals(0, app.items[0].quality);

	}
    
    @Test
    void conjuredItemTest() {
//    	increase in quality as sellIn drops under 10 and 5 respectively
	    Item[] items = new Item[] { new Item("Conjured common item", 15, 40) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assertions.assertEquals("Conjured common item", app.items[0].name);
	    Assertions.assertEquals(15-1, app.items[0].sellIn);
	    Assertions.assertEquals(40-2, app.items[0].quality);

	}
    
    @Test
    void conjuredItemExpiredTest()  {
//    	increase in quality as sellIn drops under 10 and 5 respectively
	    Item[] items = new Item[] { new Item("Conjured expired item", -1, 40) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assertions.assertEquals("Conjured expired item", app.items[0].name);
	    Assertions.assertEquals(-2, app.items[0].sellIn);
	    Assertions.assertEquals(40-4, app.items[0].quality);

	}
    
    @Test
    void itemWithOutOfBoundQuality() throws Exception {
//    	quality can never be above 50 (unless SULFURAS)
//    	the value will reset to closest valid value
    	Item[] items = new Item[] { new Item("Aged Brie", 9, 51) };
 		GildedRose app = new GildedRose(items);
 		app.updateQuality();
 		Assertions.assertEquals(AGED_BRIE, app.items[0].name);
 	    Assertions.assertEquals(9-1, app.items[0].sellIn);
 	    Assertions.assertEquals(50, app.items[0].quality);
    }
}
