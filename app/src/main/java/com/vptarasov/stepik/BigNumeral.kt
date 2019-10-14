package com.vptarasov.stepik

import java.io.File
import java.io.InputStream
import java.math.BigInteger

class BigNumeral {

    private var numDouble = 0.0
    private var numBigDecimal = 0.0

    fun getStringsFromFile(): String {
        /*File("/home/dev/Documents/BigNumeralList").forEachLine {
            getDoubleFromString(
               it
           )
       }*/
        val inputStream: InputStream = File("/home/dev/Documents/BigNumeralList").inputStream()
        return inputStream.bufferedReader().use { it.readText() }
    }

    fun countResult(): String {
        val reader = File("/home/dev/Documents/BigNumeralList").bufferedReader()
        while (true) {
            val line = reader.readLine() ?: break
            numDouble += getDoubleFromString(line)
        }
        return getFirstNineDigits(numDouble)
    }


    fun getDoubleFromString(str: String): Double {
        val newStr = "0.$str"
        val doub = newStr.toDouble()
        numDouble += doub
        return doub
    }

    fun getFirstNineDigits(double: Double): String {
        val stringFromDouble = double.toString()
        return stringFromDouble.replace(".", "").substring(0, 9)
    }

    fun countWithBigInteger(): String {
        var sumBigInteger: BigInteger = 0.toBigInteger()
        val reader = File("/home/dev/Documents/BigNumeralList").bufferedReader()
        while (true) {
            val singleBigInteger = BigInteger(reader.readLine() ?: break)

            sumBigInteger += singleBigInteger
        }
        return sumBigInteger.toString().substring(0, 9)
    }

    fun fromIntToHex(){
        val input = "101010111100"
        val hex = BigInteger(input, 2).toString(16)
        print(hex)
    }


}