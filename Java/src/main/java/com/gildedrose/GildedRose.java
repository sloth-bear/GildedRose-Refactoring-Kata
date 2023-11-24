package com.gildedrose;

import com.gildedrose.adjuster.ItemSellInAdjuster;
import com.gildedrose.policy.ItemQualityPolicy;
import com.gildedrose.policy.ItemQualityPolicyFactory;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            final ItemQualityPolicy policy = ItemQualityPolicyFactory.create(item);
            policy.apply();

            final ItemSellInAdjuster sellInAdjuster = new ItemSellInAdjuster(item);
            sellInAdjuster.decreaseSellIn();
        }
    }
}
