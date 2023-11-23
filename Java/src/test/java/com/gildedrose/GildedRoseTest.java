package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private static final String AGED_BRIE_CHEESE_NAME = "Aged Brie";
    private static final String BACKSTAGE_PASSES_NAME = "Backstage passes to a TAFKAL80ETC concert";

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

    @Test
    void givenItemBackstagePassesUnderQuality50AndExceedSellIn10_whenUpdateQuality_thenQuality1Increased() {
        // given
        final Item[] items1 = new Item[] { new Item(BACKSTAGE_PASSES_NAME, 11, 2) };
        GildedRose app1 = new GildedRose(items1);

        final Item[] items2 = new Item[] { new Item(BACKSTAGE_PASSES_NAME, 78, 0) };
        GildedRose app2 = new GildedRose(items2);

        // when
        app1.updateQuality();
        app2.updateQuality();

        // then
        assertEquals(3, app1.items[0].quality);
        assertEquals(1, app2.items[0].quality);
    }

    @Test
    void givenItemBackstagePassesUnderQuality50AndBetweenSellIn6And10_whenUpdateQuality_thenQuality2Increased() {
        // given
        final Item[] items1 = new Item[] { new Item(BACKSTAGE_PASSES_NAME, 10, 2) };
        GildedRose app1 = new GildedRose(items1);

        final Item[] items2 = new Item[] { new Item(BACKSTAGE_PASSES_NAME, 6, 0) };
        GildedRose app2 = new GildedRose(items2);

        // when
        app1.updateQuality();
        app2.updateQuality();

        // then
        assertEquals(4, app1.items[0].quality);
        assertEquals(2, app2.items[0].quality);
    }

    @Test
    void givenItemBackstagePassesUnder50QualityAndUnderSellIn5_whenUpdateQuality_thenQuality3Increased() {
        // given
        final Item[] items1 = new Item[] { new Item(BACKSTAGE_PASSES_NAME, 5, 2) };
        GildedRose app1 = new GildedRose(items1);

        final Item[] items2 = new Item[] { new Item(BACKSTAGE_PASSES_NAME, 1, 0) };
        GildedRose app2 = new GildedRose(items2);

        // when
        app1.updateQuality();
        app2.updateQuality();

        // then
        assertEquals(5, app1.items[0].quality);
        assertEquals(3, app2.items[0].quality);
    }

    @Test
    void givenItemBackstagePassesUnder50QualityAndUnderSellIn0_whenUpdateQuality_thenQuality0() {
        // given
        final Item[] items1 = new Item[] { new Item(BACKSTAGE_PASSES_NAME, 0, 4) };
        GildedRose app1 = new GildedRose(items1);

        final Item[] items2 = new Item[] { new Item(BACKSTAGE_PASSES_NAME, -1, 6) };
        GildedRose app2 = new GildedRose(items2);

        // when
        app1.updateQuality();
        app2.updateQuality();

        // then
        assertEquals(0, app1.items[0].quality);
        assertEquals(0, app2.items[0].quality);
    }

}
