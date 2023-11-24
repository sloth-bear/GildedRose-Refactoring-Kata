package com.gildedrose.adjuster;

import com.gildedrose.Item;
import com.gildedrose.ItemName;

public class ItemQualityAdjuster {

    private final Item item;

    public ItemQualityAdjuster(final Item item) {
        this.item = item;
    }

    public void setZeroQuality() {
        this.item.quality = 0;
    }

    public void decreaseQuality() {
        if (ItemName.SULFURAS.getName().equals(item.name) || item.quality <= 0) {
            return;
        }
        this.item.quality = item.quality - 1;
    }

    public void increaseQuality() {
        if (item.quality >= 50) {
            return;
        }
        this.item.quality = item.quality + 1;
    }
}
