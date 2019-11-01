package com.vptarasov.stepik

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TypeCastTest {

    var typeCast: TypeCast? = null
    private val min1 = "1410"
    private val min2 = "90"
    private val min3 = "141000"

    @Before
    fun setUp() {
        typeCast = TypeCast()
    }

    @Test
    fun minutesToDate() {
        val result1 = typeCast?.minutesToDate(min1)
        val result2 = typeCast?.minutesToDate(min2)
        val result3 = typeCast?.minutesToDate(min3)

        Assert.assertEquals("AssertMinutesToDate", result1, "days: 1\nhours: 0")
        Assert.assertEquals("AssertMinutesToDate2", result2, "days: 0\nhours: 2")
        Assert.assertEquals("AssertMinutesToDate3", result3, "days: 0\nhours: 0")
    }

    @Test
    fun mileToKM() {
        val km = "1"
        val result = typeCast?.mileToKM(km)

        Assert.assertEquals("AssertMileToKM", result, "1.852")
    }

    @Test
    fun intToDigits() {
        val input = "123456789"
        val result = typeCast?.intToDigits(input)

        Assert.assertEquals("AssertIntToDigits", result, "1 2 3 4 5 6 7 8 9 ")
    }

    @Test
    fun calculate() {
        val input = "4 + 1 * 2 - 2 * 2"
        val inputDivide = "1 / 2"
        val inputIntOrDouble = "0.25"
        val inputCheckForParenthesis = "10 * (1 + 2)".split(" ")
        val inputgetNewArray = "10 * (1 + 2)".split(" ")
        val inputFromParenthisToResult = "234.08 - 10 * (1.5 + 2.5) / 9".split(" ")

        val result = typeCast?.calculate(input)
        val resultDivide = typeCast?.calculate(inputDivide)
        val intOrDouble = typeCast?.checkIntOrDouble(inputIntOrDouble)
        val checkForParenthesis =
            typeCast?.checkForParenthesis(inputCheckForParenthesis as ArrayList<String>)
        val fromParenthisToResult =
            typeCast?.fromParenthisToResult(inputCheckForParenthesis as ArrayList<String>)
        val getNewArray = typeCast?.getNewArray(inputgetNewArray as ArrayList<String>)
        val getResultCalculation =
            typeCast?.getResultCalculation(inputFromParenthisToResult as ArrayList<String>)

        Assert.assertEquals("AssertCalculate", result, "2.0")
        Assert.assertEquals("AssertCalculate", resultDivide, "0.5")
        Assert.assertEquals("AssertCalculate", intOrDouble, "0.25")
        Assert.assertEquals("AssertCalculate", checkForParenthesis, "30.0")
        Assert.assertEquals("AssertCalculate", fromParenthisToResult, "30.0")
        Assert.assertEquals("AssertCalculate", getNewArray?.get(getNewArray.size - 1), "3.0")
        Assert.assertEquals("AssertCalculate", getResultCalculation, "229.636")

    }

}