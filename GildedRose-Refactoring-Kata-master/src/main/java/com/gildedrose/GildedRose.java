package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String CONCERT_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String LEGENDARY = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int item = 0; item < items.length; item++) {
            ITEM_TYPE itemType = ItemTypeFactory.getItemType(items[item].getName());
            itemType.updateQuality(items, item);

        }
    }

}