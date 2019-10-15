package com.vptarasov.stepik

import java.util.*
import kotlin.collections.ArrayList

class Collections {

    val intList: MutableList<Int> = ArrayList()
    var totalNum = 0

    fun deleteCopies(inputList: List<String>): List<String> {
        val listOfUsers = inputList.toSet()
        return listOfUsers.toList()
    }

    fun setUsersWithAlphabet(inputList: List<String>): MutableList<MutableList<String>> {
        var user = ""
        var listUsersByChar: MutableList<String>? = ArrayList()
        val listOfUsersSorted: MutableList<MutableList<String>> = ArrayList()
        val listOfUsers = inputList.toSortedSet()
        for (i in listOfUsers) {
            if ("" != user) {
                if (i[0] != user[0]) {
                    listUsersByChar = ArrayList()
                    listUsersByChar.add(i)
                    listOfUsersSorted.add(listUsersByChar)
                } else {
                    listUsersByChar?.add(i)
                }
            }else{
                listUsersByChar = ArrayList()
                listUsersByChar.add(i)
                listOfUsersSorted.add(listUsersByChar)
            }

            user = i
        }
        return listOfUsersSorted
    }

    private fun getNumericalValue(str: String): Int {
        var sum = 0
        val array = str.replace(" ", "").toCharArray()
        for (i in array) {
            sum += i.toInt()
        }
        return sum
    }

    fun getAnagram(s1: String, s2: String): Boolean {

        return getNumericalValue(s1) == getNumericalValue(s2)
    }

    fun findSubstrings(text: String, substring: String) : MutableList<Int>{

        val num = text.indexOf(substring)
        if (num != -1){
            totalNum += num
            intList.add(totalNum)
            totalNum += substring.length
            findSubstrings(text.substring(num+substring.length), substring)
        }else {
            return intList
        }
        return intList
    }

    fun lexicographicOrder(){
        //val input = arrayOf(2, 3, 5, 7, 11, 13, 17, 19)
        val input = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

       /* for (i in 0..4){
            Arrays.sort(input) { o1, o2 -> o1!!.toString().compareTo(o2!!.toString()) }
        }

        print(input.joinToString { "" })*/

        val sarr = arrayOfNulls<String>(input.size)
        // convent the array to a String array
        for (i in sarr.indices) {
            sarr[i] = input[i].toString()
        }
        // sort the String array (descending lexicographical order)
        Arrays.sort(sarr)
        // assign the sorted String array back to the input int array in reverse order
        for (i in sarr.indices) {
            input[i] = Integer.parseInt(sarr[sarr.size - 1 - i])
        }

        print((input.toString()))

    }

}