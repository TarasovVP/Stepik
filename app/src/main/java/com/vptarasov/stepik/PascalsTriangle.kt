package com.vptarasov.stepik

object PascalsTriangle {
    fun computeTriangle(rows: Int): List<List<Int>> {
        require(rows >= 0) { "Number of rows must be >= 0" }

        val triangle = List(rows + 1) { i -> IntArray(i) { 1 } }

        (3..rows).forEach { i ->
            triangle[i].forEachIndexed { j, _ ->
                if (j != 0 && j != triangle[i].lastIndex) {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j]
                }
            }
        }

        return triangle.map { it.toList() }.drop(1)
    }

    fun pascalTriangle(rows: Int) {
        val triangle = List(rows + 1) { i -> IntArray(i) { 1 } }

        (3..rows).forEach { i ->
            triangle[i].forEachIndexed { j, _ ->
                if (j != 0 && j != triangle[i].lastIndex) {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j]
                    val row = triangle[i][j].toString()
                    //println("debug row $row")
                }
            }
        }
        //triangle.map { it.toList() }.drop(1)
        val triangleFinal = triangle.map { it.toList() }.drop(1)
        //println("debug row $triangleFinal")

        for (i in triangleFinal){

              println(i.joinToString("."))


        }
    }

}