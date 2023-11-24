package com.gildedrose.policy.quality;

import com.gildedrose.Item;

public class SulfurasQualityPolicy implements ItemQualityPolicy {

    public static final int LEGENDARY_QUALITY = 80;
    private final Item item;

    public SulfurasQualityPolicy(final Item item) {
        this.item = item;
    }

    @Override
    public void apply() {
        this.item.quality = LEGENDARY_QUALITY;
    }
}
