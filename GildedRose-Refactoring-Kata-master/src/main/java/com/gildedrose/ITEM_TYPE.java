package com.gildedrose;

import java.util.function.BiConsumer;

public enum ITEM_TYPE {
    AGED_BRIE(ITEM_TYPE::updateAgeBrieQuality),
    CONCERT_PASS(ITEM_TYPE::updateConcertPassQuality),
    LEGENDARY(ITEM_TYPE::updateLegendaryQuality),
    OTHER(ITEM_TYPE::updateSomeItemQuality);


    ITEM_TYPE(BiConsumer<Item[], Integer> itemConsumer) {
        this.itemConsumer = itemConsumer;
    }

    BiConsumer<Item[], Integer> itemConsumer;

    static void updateAgeBrieQuality(Item[] items, int item) {
        if (items[item].getQuality() < 50) {
            items[item].setQuality(items[item].getQuality() + 1);

        }
        items[item].setSellIn(items[item].getSellIn() - 1);

        if (items[item].getQuality() < 50 && items[item].getSellIn() < 0) {
            items[item].setQuality(items[item].getQuality() + 1);
        }
    }

    static void updateConcertPassQuality(Item[] items, int item) {
        if (items[item].getQuality() < 50) {
            items[item].setQuality(items[item].getQuality() + 1);

            if (items[item].getSellIn() < 11 && items[item].getQuality() < 50) {
                items[item].setQuality(items[item].getQuality() + 1);
            }

            if (items[item].getSellIn() < 6 && items[item].getQuality() < 50) {
                items[item].setQuality(items[item].getQuality() + 1);
            }
        }

        items[item].setSellIn(items[item].getSellIn() - 1);

        if (items[item].getSellIn() < 0) {
            items[item].setQuality(items[item].getQuality() - items[item].getQuality());
        }
    }

    static void updateLegendaryQuality(Item[] items, int item) {
        // No update for this kind of item
    }

    static void updateSomeItemQuality(Item[] items, int item) {
        if (items[item].getQuality() > 0 && !items[item].getName().equals(GildedRose.LEGENDARY)) {
            items[item].setQuality(items[item].getQuality() - 1);
        }

        if (!items[item].getName().equals(GildedRose.LEGENDARY)) {
            items[item].setSellIn(items[item].getSellIn() - 1);
        }

        if (items[item].getSellIn() < 0 && items[item].getQuality() > 0 && !items[item].getName().equals(GildedRose.LEGENDARY)) {
            items[item].setQuality(items[item].getQuality() - 1);
        }
    }

    void updateQuality(Item[] items, int itemId) {
        itemConsumer.accept(items, itemId);
    }
}
