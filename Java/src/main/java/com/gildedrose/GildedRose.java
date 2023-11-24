package com.gildedrose;

import com.gildedrose.adjuster.ItemSellInAdjuster;
import com.gildedrose.policy.AgedBrieQualityPolicy;
import com.gildedrose.policy.BackstagePassesQualityPolicy;
import com.gildedrose.policy.DefaultQualityPolicy;
import com.gildedrose.policy.ItemQualityPolicy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.gildedrose.ItemName.AGED_BRIE;
import static com.gildedrose.ItemName.BACKSTAGE_PASSES;

class GildedRose {

    private static final Map<String, Function<Item, ItemQualityPolicy>> ADJUSTER_MAP;

    static {
        ADJUSTER_MAP = new HashMap<>();
        ADJUSTER_MAP.put(AGED_BRIE.getName(), AgedBrieQualityPolicy::new);
        ADJUSTER_MAP.put(BACKSTAGE_PASSES.getName(), BackstagePassesQualityPolicy::new);
    }

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            final ItemQualityPolicy qualityPolicy = ADJUSTER_MAP
                .getOrDefault(item.name, DefaultQualityPolicy::new)
                .apply(item);
            qualityPolicy.apply();

            final ItemSellInAdjuster sellInAdjuster = new ItemSellInAdjuster(item);
            sellInAdjuster.decreaseSellIn();
        }
    }
}
