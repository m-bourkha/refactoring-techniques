package com.gildedrose;

public class ItemTypeFactory {
    public static ItemType getItemType(Item[] items1, int item) {
        ItemType itemType;
        switch (items1[item].getName()) {
            case GildedRose.AGED_BRIE:
                itemType = ItemType.AGED_BRIE;
                break;
            case GildedRose.CONCERT:
                itemType = ItemType.CONCERT;
                break;
            case GildedRose.SULFURAS_HAND_OF_RAGNAROS:
                itemType = ItemType.SULFURAS_HAND_OF_RAGNAROS;
                break;
            default:
                itemType = ItemType.OTHER;
                break;
        }
        return itemType;
    }
}