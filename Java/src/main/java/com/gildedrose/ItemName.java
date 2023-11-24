package com.gildedrose;

public enum ItemName {

    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros");

    private final String name;

    ItemName(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
