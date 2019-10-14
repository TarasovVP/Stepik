package com.vptarasov.stepik

import org.junit.Assert
import org.junit.Test

class CryptoTest {

    @Test
    fun getCryptoTest(){
        val crypto = Crypto()
        val inputStringOne = "aaaaaabbbbbaccccddeeeee"
        val inputStringTwo = "abade"

        Assert.assertEquals("AssertCryptoCodingOne", crypto.getCryptoCode(inputStringOne), "a6b5a1c4d2e5")
        Assert.assertEquals("AssertCryptoCodingOne", crypto.getCryptoCode(inputStringTwo), "a1b1a1d1e1")
    }
}