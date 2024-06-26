package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name == "Aged Brie") {
                item.updateQualityBy(
                    when {
                        item.sellInDays < 1 -> 2
                        else -> 1
                    }
                )
                item.updateSellInDaysBy(-1)
            } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                item.updateQualityBy(
                    when {
                        item.sellInDays < 1 -> -item.quality
                        item.sellInDays < 6 -> 3
                        item.sellInDays < 11 -> 2
                        else -> 1
                    }
                )
                item.updateSellInDaysBy(-1)
            } else if (item.name == "Sulfuras, Hand of Ragnaros") {
                item.updateSellInDaysBy(0)
            } else {
                item.updateQualityBy(
                    when {
                        item.sellInDays < 1 -> -2
                        else -> -1
                    }
                )
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

