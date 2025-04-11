package com.gildedrose;

public class Item {

    private  String name;
    private  int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }



    public int getSellIn() {
        return sellIn;
    }

    public String getName() {
        return name;
    }

    public int getQuality() {
        return quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }
}
