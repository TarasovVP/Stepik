package com.vptarasov.stepik

class BigNumerals {

    fun getFirstNineDigits(double: Double): String{
    val stringFromDouble = double.toString()
        return stringFromDouble.replace(".", "").substring(0, 9)
    }



}