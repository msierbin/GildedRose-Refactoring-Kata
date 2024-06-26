package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name == "Aged Brie") {
                item.updateQualityBy(1)
                if (item.sellIn < 1) {
                    item.updateQualityBy(1)
                }
                item.updateSellIn()
            } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                item.updateQualityBy(1)
                if (item.sellIn < 11) {
                    item.updateQualityBy(1)
                }
                if (item.sellIn < 6) {
                    item.updateQualityBy(1)
                }
                if (item.sellIn < 1) {
                    item.quality = 0
                }
                item.updateSellIn()
            } else if (item.name == "Sulfuras, Hand of Ragnaros") {
                // empty
            } else {
                item.updateQualityBy(-1)
                if (item.sellIn < 1) {
                    item.updateQualityBy(-1)
                }
                item.updateSellIn()
            }
        }
    }

}

//- The `Quality` of an item is never negative
//- The `Quality` of an item is never more than `50`
private fun Item.updateQualityBy(increment: Int) {
    val newQuality = this.quality + increment
    if (newQuality in 0..50) {
        this.quality = newQuality
    }
}

private fun Item.updateSellIn() {
    this.sellIn -= 1
}

