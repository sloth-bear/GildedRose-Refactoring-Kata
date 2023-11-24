package com.gildedrose.policy.quality;

import com.gildedrose.Item;
import com.gildedrose.adjuster.ItemQualityAdjuster;

public class DefaultQualityPolicy implements ItemQualityPolicy {

    private final Item item;

    public DefaultQualityPolicy(final Item item) {
        this.item = item;
    }

    @Override
    public void apply() {
        final ItemQualityAdjuster adjuster = new ItemQualityAdjuster(this.item);
        adjuster.decreaseQuality();

        if (this.item.sellIn <= 0) {
            adjuster.decreaseQuality();
        }
    }
}
