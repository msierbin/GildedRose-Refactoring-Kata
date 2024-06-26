package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            createCustomItem(item).updateQuantity()
        }
    }

    private fun createCustomItem(item: Item): CustomItem {
        return when (item.name) {
            "Aged Brie" -> AgedBrie(item)
            "Backstage passes to a TAFKAL80ETC concert" -> BackstagePass(item)
            "Sulfuras, Hand of Ragnaros" -> Sulfuras(item)
            else -> DefaultItem(item)
        }
    }
}

// I cannot modify the Item class directly (base od the desc), so I would like to use inheritance and polymorphism by
// creating a wrapper and decorator for your custom behavior in an object oriented way. Factory method is used to create
// the correct custom item based on the item name.
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

class Sulfuras(private val item: Item) : CustomItem(item) {
    override fun updateQuantity() {
        // do nothing
    }
}

class DefaultItem(private val item: Item) : CustomItem(item)

//- The `Quality` of an item is never negative
//- The `Quality` of an item is never more than `50`
private fun Item.updateQualityBy(increment: Int) {
    if (increment == 0) return
    val newQuality = this.quality + increment
    this.quality = newQuality.coerceIn(minimumValue = 0, maximumValue = 50)
}

private fun Item.updateSellInDaysBy(increment: Int) {
    if (increment == 0) return
    this.sellInDays += increment
}

