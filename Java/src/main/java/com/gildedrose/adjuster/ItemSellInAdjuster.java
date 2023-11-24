package com.gildedrose.adjuster;

import com.gildedrose.Item;

public class ItemSellInAdjuster {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private final Item item;

    public ItemSellInAdjuster(final Item item) {
        this.item = item;
    }

    public void decreaseSellIn() {
        if (this.item.name.equals(SULFURAS)) {
            return;
        }
        this.item.sellIn = item.sellIn - 1;
    }
}
