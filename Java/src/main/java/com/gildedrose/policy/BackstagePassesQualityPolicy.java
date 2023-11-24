package com.gildedrose.policy;

import com.gildedrose.Item;
import com.gildedrose.adjuster.ItemQualityAdjuster;

public class BackstagePassesQualityPolicy implements ItemQualityPolicy {

    private final Item item;

    public BackstagePassesQualityPolicy(final Item item) {
        this.item = item;
    }

    @Override
    public void apply() {
        final ItemQualityAdjuster adjuster = new ItemQualityAdjuster(item);
        adjuster.increaseQuality();

        if (item.sellIn < 11) {
            adjuster.increaseQuality();
        }

        if (item.sellIn < 6) {
            adjuster.increaseQuality();
        }

        if (item.sellIn <= 0) {
            adjuster.setZeroQuality();
        }
    }
}
