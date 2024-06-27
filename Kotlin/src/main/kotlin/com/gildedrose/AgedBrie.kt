package com.gildedrose

class AgedBrie(private val item: Item) : CustomItem(item) {
    override fun updateQuantity() {
        item.updateSellInDaysBy(-1)
        item.updateQualityBy(
            when {
                item.sellInDays < 0 -> 2
                else -> 1
            }
        )
    }
}