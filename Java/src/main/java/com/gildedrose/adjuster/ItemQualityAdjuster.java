package com.gildedrose.adjuster;

import com.gildedrose.Item;

public class ItemQualityAdjuster {

    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;
    private final Item item;

    public ItemQualityAdjuster(final Item item) {
        this.item = item;
    }

    public void setZeroQuality() {
        this.item.quality = 0;
    }

    public void decreaseQuality() {
        if (item.quality <= MIN_QUALITY) {
            return;
        }
        this.item.quality--;
    }

    public void increaseQuality() {
        if (item.quality >= MAX_QUALITY) {
            return;
        }
        this.item.quality++;
    }
}
