package com.gildedrose

abstract class CustomItem(private val item: Item) {
    open fun updateQuantity() {
        item.updateSellInDaysBy(-1)
        item.updateQualityBy(
            when {
                item.sellInDays < 0 -> -2
                else -> -1
            }
        )
    }
}

//- The `Quality` of an item is never negative
//- The `Quality` of an item is never more than `50`
fun Item.updateQualityBy(increment: Int) {
    if (increment == 0) return
    val newQuality = this.quality + increment
    this.quality = newQuality.coerceIn(minimumValue = 0, maximumValue = 50)
}

fun Item.updateSellInDaysBy(increment: Int) {
    if (increment == 0) return
    this.sellInDays += increment
}