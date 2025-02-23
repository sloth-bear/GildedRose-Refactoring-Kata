package com.gildedrose.policy.quality;

import com.gildedrose.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.gildedrose.ItemName.*;

public class ItemQualityPolicyFactory {

    private static final Map<String, Function<Item, ItemQualityPolicy>> POLICY_MAP;

    static {
        POLICY_MAP = new HashMap<>();
        POLICY_MAP.put(AGED_BRIE.getName(), AgedBrieQualityPolicy::new);
        POLICY_MAP.put(BACKSTAGE_PASSES.getName(), BackstagePassesQualityPolicy::new);
        POLICY_MAP.put(SULFURAS.getName(), SulfurasQualityPolicy::new);
        POLICY_MAP.put(CONJURED.getName(), ConjuredQualityPolicy::new);
    }

    private ItemQualityPolicyFactory() {
        throw new UnsupportedOperationException();
    }

    public static ItemQualityPolicy create(final Item item) {
        return POLICY_MAP.getOrDefault(item.name, DefaultQualityPolicy::new).apply(item);
    }
}
