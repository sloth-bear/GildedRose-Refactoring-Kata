package com.gildedrose.policy.sellin;

import com.gildedrose.Item;
import com.gildedrose.adjuster.ItemSellInAdjuster;

public class DefaultSellInPolicy implements ItemSellInPolicy {

    private final Item item;

    public DefaultSellInPolicy(final Item item) {
        this.item = item;
    }

    @Override
    public void apply() {
        final ItemSellInAdjuster adjuster = new ItemSellInAdjuster(item);
        adjuster.decreaseSellIn();
    }
}
