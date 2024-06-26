package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name == "Aged Brie") {
                if (item.quality < 50) {
                    item.quality += 1
                }
            } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                if (item.quality < 50) {
                    item.quality += 1

                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality += 1
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality += 1
                        }
                    }
                }
            } else {
                if (item.name == "Sulfuras, Hand of Ragnaros") {
                    if (item.quality > 0) {
                        // empty
                    }
                } else {
                    if (item.quality > 0) {
                        item.quality -= 1
                    }
                }
            }

            if (item.name == "Sulfuras, Hand of Ragnaros") {
                // empty
            } else {
                item.sellIn -= 1
            }

            if (item.name == "Aged Brie") {
                if (item.quality < 50) {
                    if (item.sellIn < 0) {
                        item.quality += 1
                    }
                }
            } else {
                if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                    if (item.sellIn < 0) {
                    item.quality = 0
                        }
                } else {
                    if (item.quality > 0) {
                        if (item.sellIn < 0) {
                            if (item.name == "Sulfuras, Hand of Ragnaros") {
                                if (item.quality > 0) {
                                    if (item.sellIn < 0) {
                                        // empty
                                    }
                                }
                            } else {
                                if (item.quality > 0) {
                                    if (item.sellIn < 0) {
                                        item.quality -= 1
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}

