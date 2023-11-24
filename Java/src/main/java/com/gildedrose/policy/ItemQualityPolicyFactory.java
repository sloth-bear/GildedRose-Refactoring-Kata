package com.gildedrose.policy;

import com.gildedrose.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.gildedrose.ItemName.AGED_BRIE;
import static com.gildedrose.ItemName.BACKSTAGE_PASSES;

public class ItemQualityPolicyFactory {

    private static final Map<String, Function<Item, ItemQualityPolicy>> POLICY_MAP;

    static {
        POLICY_MAP = new HashMap<>();
        POLICY_MAP.put(AGED_BRIE.getName(), AgedBrieQualityPolicy::new);
        POLICY_MAP.put(BACKSTAGE_PASSES.getName(), BackstagePassesQualityPolicy::new);
    }

    private ItemQualityPolicyFactory() {
        throw new UnsupportedOperationException();
    }

    public static ItemQualityPolicy create(final Item item) {
        return POLICY_MAP.getOrDefault(item.name, DefaultQualityPolicy::new).apply(item);
    }
}
