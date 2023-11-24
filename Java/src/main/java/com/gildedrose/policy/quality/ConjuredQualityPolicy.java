package com.gildedrose.policy.quality;

import com.gildedrose.Item;
import com.gildedrose.adjuster.ItemQualityAdjuster;

public class ConjuredQualityPolicy implements ItemQualityPolicy {

    private final Item item;

    public ConjuredQualityPolicy(final Item item) {
        this.item = item;
    }

    @Override
    public void apply() {
        final ItemQualityAdjuster adjuster = new ItemQualityAdjuster(this.item);
        adjuster.decreaseQuality();
        adjuster.decreaseQuality();

        if (item.sellIn <= 0) {
            adjuster.decreaseQuality();
            adjuster.decreaseQuality();
        }
    }
}
