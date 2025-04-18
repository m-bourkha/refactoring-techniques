package com.gildedrose;

public class ItemTypeFactory {

    private ItemTypeFactory() {
    }

    static ITEM_TYPE getItemType(String name1) {
        return switch (name1) {
            case GildedRose.AGED_BRIE -> ITEM_TYPE.AGED_BRIE;
            case GildedRose.CONCERT_PASS -> ITEM_TYPE.CONCERT_PASS;
            case GildedRose.LEGENDARY -> ITEM_TYPE.LEGENDARY;
            default -> ITEM_TYPE.OTHER;
        };
    }
}