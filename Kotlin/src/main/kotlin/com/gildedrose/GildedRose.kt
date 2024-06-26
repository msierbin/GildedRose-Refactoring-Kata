package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name == "Aged Brie") {
                if (item.quality < 50) {
                    item.updateQuality(1)
                }
                if (item.quality < 50 && item.sellIn < 1) {
                    item.updateQuality(1)
                }
                item.updateSellIn()
            } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                if (item.quality < 50) {
                    item.updateQuality(1)
                    if (item.quality < 50 && item.sellIn < 11) {
                        item.updateQuality(1)
                    }
                    if (item.quality < 50 && item.sellIn < 6) {
                        item.updateQuality(1)
                    }
                }
                if (item.sellIn < 1) {
                    item.quality = 0
                }
                item.updateSellIn()
            } else if (item.name == "Sulfuras, Hand of Ragnaros") {
                // empty
            } else {
                if (item.quality > 0) {
                    item.updateQuality(-1)
                }
                if (item.quality > 0 && item.sellIn < 1) {
                    item.updateQuality(-1)
                }
                item.updateSellIn()
            }
        }
    }

}

//- The `Quality` of an item is never negative
//- The `Quality` of an item is never more than `50`
private fun Item.updateQuality(increment: Int) {
    val newQuality = this.quality + increment
    if (newQuality in 0..50) {
        this.quality = newQuality
    }
}

private fun Item.updateSellIn() {
    this.sellIn -= 1
}

