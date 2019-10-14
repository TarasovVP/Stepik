package com.vptarasov.stepik

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import kotlin.math.abs

class BigNumeralTest {

    lateinit var bigNumeral: BigNumeral

    @Before
    fun setUp() {
        bigNumeral = BigNumeral()
    }

    @Test
    fun getStringsFromFile(){

        assertEquals("AssertStringsFromFile", bigNumeral.getStringsFromFile(), "123")
    }

    @Test
    fun countResult(){
        assertEquals("AssertLinesFromFile", bigNumeral.countResult(), "599603249")
    }

    @Test
    fun bigNumeralAdding() {

    }

    @Test
    fun getDoubleFromString(){

        val expectedDouble = bigNumeral.getDoubleFromString("123456789")

        assertEquals("AssertDoubleFromString", expectedDouble, 0.123456789, abs(expectedDouble-0.123456789))
    }

    @Test
    fun getFirstNineDigits() {

        assertEquals("AssertFirstNineDigits", bigNumeral.getFirstNineDigits(1.2345678901), "123456789")
    }

    @Test
    fun countWithBigInteger(){
        assertEquals("AssertWithBigInteger", bigNumeral.countWithBigInteger(), "599603249")
    }

    @Test
    fun fromIntToHex(){
        assertEquals("AssertfromIntToHex", bigNumeral.fromIntToHex(), "599603249")
    }
}