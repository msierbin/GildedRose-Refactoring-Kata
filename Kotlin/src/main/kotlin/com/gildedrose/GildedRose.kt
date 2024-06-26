package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name == "Aged Brie") {
                if (item.sellInDays < 1) {
                    item.updateQualityBy(2)
                } else {
                    item.updateQualityBy(1)
                }
                item.updateSellInDaysBy(-1)
            } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                if (item.sellInDays < 1) {
                    item.updateQualityBy(-item.quality)
                } else if (item.sellInDays < 6) {
                    item.updateQualityBy(3)
                } else if (item.sellInDays < 11) {
                    item.updateQualityBy(2)
                } else {
                    item.updateQualityBy(1)
                }
                item.updateSellInDaysBy(-1)
            } else if (item.name == "Sulfuras, Hand of Ragnaros") {
                item.updateSellInDaysBy(0)
            } else {
                if (item.sellInDays < 1) {
                    item.updateQualityBy(-2)
                } else {
                    item.updateQualityBy(-1)
                }
                item.updateSellInDaysBy(-1)
            }
        }
    }

}

//- The `Quality` of an item is never negative
//- The `Quality` of an item is never more than `50`
private fun Item.updateQualityBy(increment: Int) {
    val newQuality = this.quality + increment
    this.quality = newQuality.coerceIn(minimumValue = 0, maximumValue = 50)
}

private fun Item.updateSellInDaysBy(increment: Int) {
    this.sellInDays += increment
}

