package com.example.kotlindemo.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.kotlindemo.R
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var stack = Stack<ArrayList<String>>();
    var TAG = MainActivity::class.qualifiedName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var preBtn = findViewById<Button>(R.id.preId)
        var nextBtn = findViewById<Button>(R.id.nextId)
        preBtn.setOnClickListener(this)
        nextBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.preId -> {
                stack.pop()
                Log.e(TAG, "stack=" + stack)
            }
            R.id.nextId -> {

                var num = (0..5)
                val source = "abcdefgh"
                val arrayList=ArrayList<String>()
                val src="ghghhjjjgft"
                for (i in num) {
                    var str = (1..10).map { src.random() }.joinToString("")
                    arrayList.add(str)
                }
                Log.e(TAG, "list=" + arrayList)
                stack.push(arrayList)
                Log.e(TAG, "stack=" +stack)


            }
        }
    }
}
