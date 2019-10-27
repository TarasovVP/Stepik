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
            } else {
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

    fun findSubstrings(text: String, substring: String): MutableList<Int> {

        val num = text.indexOf(substring)
        if (num != -1) {
            totalNum += num
            intList.add(totalNum)
            totalNum += substring.length
            findSubstrings(text.substring(num + substring.length), substring)
        } else {
            return intList
        }
        return intList
    }

    /*fun lexicographicOrder(array: Array<Int>): Array<Int?> {
        val input = array

        var k = 0
        var l = 0

        for (i in input.indices) {
            if (i < input.size-1) {
                if (input[i] < input[i + 1]) {
                    k = i
                } else {
                    break
                }
            }

        }

        for (i in input.indices) {
            if (input[k] < input[i]) {
                l = i
            }
        }

        val temp: Int
        temp = input[k]
        input[k] = input[l]
        input[l] = temp

        val arrLeft : Array<Int?> = arrayOfNulls(k)
        for (i in 0 until k){
            arrLeft[i] = input[i]
        }

        var index = 0
        val arrRight: Array<Int?> = arrayOfNulls(input.size-k)
        for (i in input.lastIndex downTo k){
            arrRight[index] = input[i]
            index++
        }

        return arrLeft + arrRight

    }
*/
    fun lexicographicOrder(seq: IntArray): IntArray? {
        var i = seq.size - 1
        var j = seq.size - 1
        while (i > 0 && seq[i] <= seq[i - 1])
            i--
        if (i == 0)
            return null
        while (seq[j] <= seq[i - 1])
            j--
        var temp = seq[i - 1]
        seq[i - 1] = seq[j]
        seq[j] = temp
        j = seq.size - 1
        while (i < j) {
            temp = seq[i]
            seq[i] = seq[j]
            seq[j] = temp
            i++
            j--
        }
        return seq
    }

    fun getNextPermutation(seq: IntArray, num: Int): String?{
        var finalArr = seq

        for (i in 0 until num){
            finalArr = lexicographicOrder(finalArr)!!
        }

        return finalArr.joinToString("", "", "")
    }

    fun averageMedian(arr: DoubleArray): String{

        val str = "1.0 2.0 3.0 4.0"
        val array = str.split(" ")
        var arr = DoubleArray(array.size)

        var index = 0
        for (i in array){
            arr[index] = i.toDouble()
            index++
        }


        var doubleResult = 0.0

        for (i in arr){
            doubleResult += i
        }

        doubleResult /= arr.size


        Arrays.sort(arr)
        val median: Double
        if (arr.size % 2 == 0)
            median =
                (arr[arr.size / 2] + arr[arr.size / 2 - 1]) / 2
        else
            median = arr[arr.size / 2]

        return "$doubleResult $median"

    }




}