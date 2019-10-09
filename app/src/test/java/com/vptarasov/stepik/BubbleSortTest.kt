package com.vptarasov.stepik

import org.junit.Assert
import org.junit.Test

class BubbleSortTest {

    @Test
    fun getIntArray(){
        val listS = listOf("1", "22", "13")
        val bubbleSort = BubbleSort()
        val intArr = bubbleSort.getIntArray(listS)
        val sortedArr = bubbleSort.bubbleSort(listS)

        Assert.assertEquals("AssertFirstElementIntArr", 1, intArr[0])
        Assert.assertEquals("AssertSecondElementIntArr", 22, intArr[1])
        Assert.assertEquals("AssertThirdElementIntArr", 13, intArr[2])

        Assert.assertEquals("AssertFirstElementSortedArr", 1, sortedArr[0])
        Assert.assertEquals("AssertSecondElementSortedArr", 13, sortedArr[1])
        Assert.assertEquals("AssertThirdElementSortedArr", 22, sortedArr[2])
    }

}