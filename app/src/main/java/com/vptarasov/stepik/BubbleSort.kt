package com.vptarasov.stepik

class BubbleSort {

    fun getIntArray(listS: List<String>): IntArray{

        val intArr = IntArray(listS.size)
        for (i in listS.indices) {
            intArr[i] = listS[i].toInt()
        }
        return intArr
    }

    fun bubbleSort(inputList: List<String>): IntArray {
        val arr = IntArray(inputList.size)
        for (i in 0 until inputList.size) {
            arr[i] = inputList[i].toInt()
        }
        var swap = true
        while (swap) {
            swap = false
            for (i in 0 until arr.size - 1) {
                if (arr[i] > arr[i + 1]) {
                    val temp = arr[i]
                    arr[i] = arr[i + 1]
                    arr[i + 1] = temp

                    swap = true
                }
            }
        }
        return arr
    }
}