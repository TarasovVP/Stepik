package com.vptarasov.stepik

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CollectionsTest {

    var collections: Collections? = null
    lateinit var str: List<String>
    lateinit var strAlphaBet: List<String>
    lateinit var s1: String
    lateinit var s2: String
    lateinit var s3: String
    lateinit var s4: String
    lateinit var s5: String
    lateinit var s6: String
    lateinit var string: String
    lateinit var subString: String

    @Before
    fun setUp() {
        collections = Collections()
        str = "Anna Ben Alex Anna Peter Jack Ben".split(" ")
        strAlphaBet = "Smith Jones Bambury Patel Brown Singh Williams Taylor Wilson Davies Evans Scott".split(" ")
        s1 = "Rail safety"
        s2 = "Fairy tales"
        s3 = "Том Нарволо Реддл"
        s4 = "Лорд Волан де Морт"
        s5 = "ф"
        s6 = "ф"
        string = "абракадабрабракадабраабракадабра1абракадабра11111111111абракадабра22абракадабра20202020202020202020абракадабра"
        subString = "абракадабра"
    }

    @Test
    fun deleteCopies() {
        val result = collections?.deleteCopies(str)

        val listActual = ArrayList<String>()
        listActual.add("Anna")
        listActual.add("Ben")
        listActual.add("Alex")
        listActual.add("Peter")
        listActual.add("Jack")

        assertEquals("AssertDeleteCopies", result, listActual)
    }

    @Test
    fun setUsersWithAlphabet(){
        val resultAlphaBet = collections?.setUsersWithAlphabet(strAlphaBet)

        val listActualAlphaBet = ArrayList<String>()
        listActualAlphaBet.add("Bambury Brown")
        listActualAlphaBet.add("Davies")
        listActualAlphaBet.add("Evans")
        listActualAlphaBet.add("Jones")
        listActualAlphaBet.add("Patel")
        listActualAlphaBet.add("Scott Singh Smith")
        listActualAlphaBet.add("Taylor")
        listActualAlphaBet.add("Williams Wilson")

        for (i in resultAlphaBet!!){
            println(i.toString().substring(1, i.toString().length-1).replace(",", ""))
        }

        assertEquals("AssertDeleteCopies", resultAlphaBet, listActualAlphaBet)
    }

    @Test
    fun findAnagrams(){
        val findAnagram = collections?.getAnagram(s1, s2)
        val findAnagramCyrill = collections?.getAnagram(s3, s4)
        val findAnagramTest = collections?.getAnagram(s5, s6)

        assertEquals("AssertFindAnagrams", findAnagram, true)
        assertEquals("AssertFindAnagrams", findAnagramCyrill, true)
        assertEquals("AssertFindAnagrams", findAnagramTest, true)
    }

    @Test
    fun findSubstrings(){
        val intList = collections?.findSubstrings(string, subString)

        assertEquals("AssertFindSubstrings", intList?.get(0), 0)
        assertEquals("AssertFindSubstrings", intList?.get(1), 21)
    }

    @Test
    fun lexicographicOrder(){
        val input = intArrayOf(1, 2, 3, 4)
        val inputSecond = intArrayOf(1, 2, 4, 3)
        val inputStepik = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val finalArray = collections?.getNextPermutation(input, 1)
        val finalArraySecond = collections?.getNextPermutation(inputSecond, 1)
        val finalArrayStepik = collections?.getNextPermutation(inputStepik, 999993)
        assertEquals("AssertlexicographicOrder", finalArray, "1243")
        assertEquals("AssertlexicographicOrderSecond", finalArraySecond, "1324")
        assertEquals("AssertlexicographicOrderStepik", finalArrayStepik, "2783914560")

    }

    @Test
    fun averageMedian(){
        val arr = doubleArrayOf(1.0, 2.0, 3.0, 4.0)
        val result = collections?.averageMedian(arr)

        assertEquals("AssertAverageMedian", result, "2.5 2.5")
    }
}