package com.gildedrose;

class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            if (item.name.equals(AGED_BRIE)) {
                increaseQuality(item);

                if (item.sellIn <= 0) {
                    increaseQuality(item);
                }
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                increaseQuality(item);

                if (item.sellIn < 11) {
                    increaseQuality(item);
                }

                if (item.sellIn < 6) {
                    increaseQuality(item);
                }

                if (item.sellIn <= 0) {
                    setZeroQuality(item);
                }
            } else {
                decreaseQuality(item);

                if (item.sellIn <= 0) {
                    decreaseQuality(item);
                }
            }

            decreaseSellIn(item);
        }
    }

    private void decreaseSellIn(final Item item) {
        if (item.name.equals(SULFURAS)) {
            return;
        }
        item.sellIn = item.sellIn - 1;
    }

    private void setZeroQuality(final Item item) {
        item.quality = 0;
    }

    private void decreaseQuality(final Item item) {
        if (item.name.equals(SULFURAS) || item.quality <= 0) {
            return;
        }
        item.quality = item.quality - 1;
    }

    private void increaseQuality(final Item item) {
        if (item.quality >= 50) {
            return;
        }
        item.quality = item.quality + 1;
    }
}
