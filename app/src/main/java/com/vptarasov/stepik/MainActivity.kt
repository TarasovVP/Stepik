package com.vptarasov.stepik

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*val listS = listOf("1", "22", "13")
        val bubbleSort = BubbleSort()
        val intArr = bubbleSort.getIntArray(listS)
        val sortedArr = bubbleSort.bubbleSort(listS)
        val tvMainActivity = tvMain
        tvMainActivity.text = intArr.asList().toString() + sortedArr.asList().toString()*/

        /*val pascalsTriangle = PascalsTriangle
        pascalsTriangle.pascalTriangle(5)*/

        /*val list = bubbleSort(intArrayOf(2,15,1,8,4))
        for (k in list) {
            Logger.getLogger(MainActivity::class.java.name).warning("Numbers $k")
        }*/





    }


}
