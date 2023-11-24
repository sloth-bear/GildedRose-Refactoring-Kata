package com.gildedrose;

import com.gildedrose.policy.quality.ItemQualityPolicy;
import com.gildedrose.policy.quality.ItemQualityPolicyFactory;
import com.gildedrose.policy.sellin.ItemSellInPolicy;
import com.gildedrose.policy.sellin.ItemSellInPolicyFactory;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            final ItemQualityPolicy qualityPolicy = ItemQualityPolicyFactory.create(item);
            qualityPolicy.apply();

            final ItemSellInPolicy sellInPolicy = ItemSellInPolicyFactory.create(item);
            sellInPolicy.apply();
        }
    }
}
