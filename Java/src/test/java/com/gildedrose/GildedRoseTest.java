package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private static final String AGED_BRIE_CHEESE_NAME = "Aged Brie";

    @Test
    void givenItemFoo_whenUpdateQuality_thenNotChangeItems() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void givenItemAgedBrieUnderQuality50_whenUpdateQuality_thenQuality1Increased() {
        // given
        final Item[] items1 = new Item[] { new Item(AGED_BRIE_CHEESE_NAME, 1, 2) };
        GildedRose app1 = new GildedRose(items1);

        final Item[] items2 = new Item[] { new Item(AGED_BRIE_CHEESE_NAME, 3, 0) };
        GildedRose app2 = new GildedRose(items2);

        // when
        app1.updateQuality();
        app2.updateQuality();

        // then
        assertEquals(3, app1.items[0].quality);
        assertEquals(1, app2.items[0].quality);
    }

    @Test
    void givenItemAgedBrie_whenUpdateQuality_thenSellIn1Decreased() {
        // given
        final Item[] items1 = new Item[] { new Item(AGED_BRIE_CHEESE_NAME, 1, 2) };
        GildedRose app1 = new GildedRose(items1);

        final Item[] items2 = new Item[] { new Item(AGED_BRIE_CHEESE_NAME, 3, 1) };
        GildedRose app2 = new GildedRose(items2);

        final Item[] items3 = new Item[] { new Item(AGED_BRIE_CHEESE_NAME, 0, 0) };
        GildedRose app3 = new GildedRose(items3);

        // when
        app1.updateQuality();
        app2.updateQuality();
        app3.updateQuality();

        // then
        assertEquals(0, app1.items[0].sellIn);
        assertEquals(2, app2.items[0].sellIn);
        assertEquals(-1, app3.items[0].sellIn);
    }

}
