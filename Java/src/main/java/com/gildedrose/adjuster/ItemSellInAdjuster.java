package com.gildedrose.adjuster;

import com.gildedrose.Item;

public class ItemSellInAdjuster {

    private final Item item;

    public ItemSellInAdjuster(final Item item) {
        this.item = item;
    }

    public void decreaseSellIn() {
        this.item.sellIn = item.sellIn - 1;
    }
}
