package com.gildedrose.policy;

import com.gildedrose.Item;
import com.gildedrose.adjuster.ItemQualityAdjuster;

public class AgedBrieQualityPolicy implements ItemQualityPolicy {

    private final Item item;

    public AgedBrieQualityPolicy(final Item item) {
        this.item = item;
    }

    @Override
    public void apply() {
        final ItemQualityAdjuster adjuster = new ItemQualityAdjuster(this.item);

        adjuster.increaseQuality();

        if (item.sellIn <= 0) {
            adjuster.increaseQuality();
        }
    }
}
