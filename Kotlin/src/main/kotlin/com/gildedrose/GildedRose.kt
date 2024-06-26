package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            createCustomItem(item).updateQuantity()
        }
    }

// I cannot modify the Item class directly (base on the desc), so I would like to use inheritance and polymorphism by
// creating a wrapper and decorator for your custom behavior in an object oriented way. Factory method is used to create
// the correct custom item based on the item name.
    private fun createCustomItem(item: Item): CustomItem {
        return when (item.name) {
            "Aged Brie" -> AgedBrie(item)
            "Backstage passes to a TAFKAL80ETC concert" -> BackstagePass(item)
            "Sulfuras, Hand of Ragnaros" -> Sulfuras(item)
            else -> DefaultItem(item)
        }
    }
}



