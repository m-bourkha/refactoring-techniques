package com.gildedrose;

import java.util.function.BiConsumer;

public enum ItemType {
    AGED_BRIE(ItemType::updateAgedBrieItem),
    CONCERT(ItemType::updateConscertPassItem),
    SULFURAS_HAND_OF_RAGNAROS(ItemType::updateSelfulare),
    OTHER(ItemType::updateOtherItem);

    BiConsumer<Item[], Integer> consumer;

    ItemType(BiConsumer<Item[], Integer> consumer) {
        this.consumer = consumer;
    }

    private static void updateAgedBrieItem(Item[] items, Integer item) {
        if (items[item].getQuality() < 50) {
            items[item].setQuality(items[item].getQuality() + 1);
            if (items[item].getSellIn() < 0) {
                items[item].setQuality(items[item].getQuality() + 1);
            }

        }
    }

    private static void updateConscertPassItem(Item[] items,int item) {
        if (items[item].getQuality() < 50) {
            items[item].setQuality(items[item].getQuality() + 1);

            if (items[item].getSellIn() < 11 && items[item].getQuality() < 50) {
                    items[item].setQuality(items[item].getQuality() + 1);
                    if (items[item].getSellIn() < 6) {
                        items[item].setQuality(items[item].getQuality() + 1);
                    }
                }


        }

        items[item].setSellIn(items[item].getSellIn() - 1);

        if (items[item].getSellIn() < 0) {
            items[item].setQuality(0);
        }
    }
    private static void updateSelfulare(Item[] items,int item) {
        // Not effect on item
    }

    private static void updateOtherItem(Item[] items, int item) {
        if (items[item].getQuality() > 0) {
            items[item].setQuality(items[item].getQuality() - 1);
        }

        items[item].setSellIn(items[item].getSellIn() - 1);

        if (items[item].getSellIn() < 0 && items[item].getQuality() > 0) {
                items[item].setQuality(items[item].getQuality() - 1);
            }

    }

    public void updateItem(Item[] items, Integer a) {
        consumer.accept(items, a);
    }
}