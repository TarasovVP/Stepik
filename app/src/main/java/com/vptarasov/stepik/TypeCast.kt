package com.vptarasov.stepik

class TypeCast {

    fun minutesToDate(min: String): String {

        val minutes = min.toInt()
        var hour: Int
        hour = if (minutes % 60 >= 30) {
            minutes / 60 + 1
        } else {
            minutes / 60
        }
        val day: Int
        if (hour == 24) {
            day = hour / 24
            hour = 0
        } else {
            day = hour / 24
            hour %= 24
        }

        return "days: $day\nhours: $hour"
    }

    fun mileToKM(input: String): String {
        val km = input.toInt()

        val result = (km * 1.852)

        return result.toString()
    }

    fun intToDigits(input: String): String {
        var result = ""

        for (i in input) {
            result += "$i "
        }
        return result
    }

    fun calculate(input: String): String {
        val elements = input.split(" ")
        var result = ""

        val listOfElements = doMultiply(elements as ArrayList<String>)
        for (i in listOfElements.indices) {
            if (i == 0) {
                result = listOfElements[0]
            }
            if (i % 2 != 0) {
                result = mathReuslt(result, elements[i + 1], elements[i])

            }

        }
        return result
    }

    fun calculate(listOfElements: ArrayList<String>): String {
        var result = ""

        val listOfElements = doMultiply(listOfElements)
        for (i in listOfElements.indices) {
            if (i == 0) {
                result = listOfElements[0]
            }
            if (i % 2 != 0) {
                result = mathReuslt(result, listOfElements[i + 1], listOfElements[i])

            }

        }
        return result
    }

    private fun doMultiply(listOfElements: ArrayList<String>): ArrayList<String> {
        for (i in listOfElements.indices) {
            if (i % 2 != 0 && "*" == listOfElements[i]) {
                val result = mathReuslt(
                    listOfElements[i - 1],
                    listOfElements[i + 1],
                    listOfElements[i]
                )
                listOfElements[i - 1] = result
                listOfElements.removeAt(i)
                listOfElements.removeAt(i)
                doMultiply(listOfElements)
                break
            }
        }
        return listOfElements
    }

    private fun mathReuslt(leftDigit: String, rightDigit: String, operator: String): String {
        var result = ""
        when (operator) {
            "+" -> result = (leftDigit.toInt() + rightDigit.toInt()).toString()
            "-" -> result = (leftDigit.toInt() - rightDigit.toInt()).toString()
            "*" -> result = (leftDigit.toInt() * rightDigit.toInt()).toString()
            "/" -> result = (leftDigit.toDouble() / rightDigit.toDouble()).toString()
        }
        return result
    }

    fun checkIntOrDouble(element: String): String {
        return if (element.contains(".")) {
            element.toDouble().toString()
        } else {
            element.toInt().toString()
        }
    }

    fun checkForParenthesis(listOfElements: ArrayList<String>): String {

        var result = ""

        if (listOfElements.any { it.contains("(") } && listOfElements.any { it.contains(")") }) {

            val firstIndex = listOfElements.indexOf(listOfElements.first { it.contains("(") })
            val lastIndex = listOfElements.lastIndexOf(listOfElements.last { it.contains(")") })

            listOfElements[firstIndex] = listOfElements[firstIndex].replace("(", "")
            listOfElements[lastIndex] = listOfElements[lastIndex].replace(")", "")

            val newArrayList: ArrayList<String> = ArrayList()
            for (i in listOfElements.indices) {
                if (i in firstIndex until lastIndex + 1)
                    newArrayList.add(listOfElements[i])
            }
            if (newArrayList.any { it.contains("(") }) {
                checkForParenthesis(newArrayList)
            } else {
                result = calculate(newArrayList)
                listOfElements[firstIndex] = result
                for (i in 1..(lastIndex - firstIndex)) {
                    listOfElements.removeAt(firstIndex + 1)
                }
            }


        }
        return result

    }

}