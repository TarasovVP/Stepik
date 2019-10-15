package com.vptarasov.stepik

import org.junit.Assert
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

        Assert.assertEquals("AssertDeleteCopies", result, listActual)
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

        Assert.assertEquals("AssertDeleteCopies", resultAlphaBet, listActualAlphaBet)
    }

    @Test
    fun findAnagrams(){
        val findAnagram = collections?.getAnagram(s1, s2)
        val findAnagramCyrill = collections?.getAnagram(s3, s4)
        val findAnagramTest = collections?.getAnagram(s5, s6)

        Assert.assertEquals("AssertFindAnagrams", findAnagram, true)
        Assert.assertEquals("AssertFindAnagrams", findAnagramCyrill, true)
        Assert.assertEquals("AssertFindAnagrams", findAnagramTest, true)
    }

    @Test
    fun findSubstrings(){
        val intList = collections?.findSubstrings(string, subString)

        Assert.assertEquals("AssertFindSubstrings", intList?.get(0), 0)
        Assert.assertEquals("AssertFindSubstrings", intList?.get(1), 21)
    }

    @Test
    fun lexicographicOrder(){
        collections?.lexicographicOrder()
    }
}