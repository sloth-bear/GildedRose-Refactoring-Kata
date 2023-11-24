package com.gildedrose.policy.sellin;

import com.gildedrose.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.gildedrose.ItemName.SULFURAS;

public class ItemSellInPolicyFactory {

    private static final Map<String, Function<Item, ItemSellInPolicy>> POLICY_MAP;

    static {
        POLICY_MAP = new HashMap<>();
        POLICY_MAP.put(SULFURAS.getName(), item -> new SulfurasSellInPolicy());
    }

    private ItemSellInPolicyFactory() {
        throw new UnsupportedOperationException();
    }

    public static ItemSellInPolicy create(final Item item) {
        return POLICY_MAP.getOrDefault(item.name, DefaultSellInPolicy::new).apply(item);
    }
}
