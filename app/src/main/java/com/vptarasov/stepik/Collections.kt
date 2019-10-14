package com.vptarasov.stepik

class Collections {

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

}