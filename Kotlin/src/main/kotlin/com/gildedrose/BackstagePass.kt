package com.gildedrose

class BackstagePass(private val item: Item) : CustomItem(item) {
    override fun updateQuantity() {
        item.sellInDays -= 1
        item.quality += when {
            item.sellInDays < 0 -> -item.quality
            item.sellInDays < 5 -> 3
            item.sellInDays < 10 -> 2
            else -> 1
        }
        item.quality = item.quality.coerceIn(0, 50)
    }
}