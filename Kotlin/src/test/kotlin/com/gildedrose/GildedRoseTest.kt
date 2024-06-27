package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun shouldWorkFor0Days() {
        val days_0 = GildedRoseTest::class.java.getResourceAsString("/expected/expected_days_0")!!
        assertEquals(days_0, mainCopy(0))
    }

    @Test
    fun shouldWorkFor1Day() {
        val days_1 = GildedRoseTest::class.java.getResourceAsString("/expected/expected_days_1")!!
        assertEquals(days_1, mainCopy(1))
    }

    @Test
    fun shouldWorkFor10Days() {
        val days_10 = GildedRoseTest::class.java.getResourceAsString("/expected/expected_days_10")!!
        assertEquals(days_10, mainCopy(10))
    }

    @Test
    fun shouldWorkFor1000Days() {
        val days_1000 = GildedRoseTest::class.java.getResourceAsString("/expected/expected_days_1000")!!
        assertEquals(days_1000, mainCopy(1000))
    }

    fun mainCopy(days: Int): String {
        var result = ""
        result += ("OMGHAI!")
        result += "\n"

        val items = listOf(
            Item("+5 Dexterity Vest", 10, 20), //
            Item("Aged Brie", 2, 0), //
            Item("Elixir of the Mongoose", 5, 7), //
            Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            Item("Conjured Mana Cake", 3, 6)
        )

        val app = GildedRose(items)

        for (i in 0..days - 1) {
            result += ("-------- day $i --------")
            result += "\n"
            result += ("name, sellIn, quality")
            result += "\n"
            for (item in items) {
                result += item
                result += "\n"
            }
            result += "\n"
            app.updateQuality()
        }
        return result
    }

    fun Class<*>.getResourceAsString(resourceName: String): String? =
        this.getResourceAsStream(resourceName)?.bufferedReader().use { it?.readText() }
}


