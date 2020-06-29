package com.neobaran.app.ruler

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
//        height_input.setUnitStr("")
//        height_number.text = "188.6 cm"
        height_input.setValueListener {
            height_number.text = "$it cm"
            val height = height_input.getValue() // get the rule current value
            v.vibrate(VibrationEffect.createOneShot(1, VibrationEffect.DEFAULT_AMPLITUDE))
        }

        //set the number precision, it should be called before setMin / setMax / setValue
        //设置精度，如40.5 40.55 必须在设置最大/最小值/当前值 之前调用
//        weight_input.setDigits(0)
//        weight_input.setValue(78.8f)           //set the current value
//        weight_input.setMinValue(10)           //set the min value
//        weight_input.setMaxValue(220)          //set the max value

//        weight_number.text = "78.8 kg"
        tv_input.setValueListener {
            tv_number.text = "$it kg"
            v.vibrate(VibrationEffect.createOneShot(1, VibrationEffect.DEFAULT_AMPLITUDE))
        }

        var text = ""
        getISOList(90, 1200).forEach { text += "$it, " }
        Log.i("Main Activity", text)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getISOList(min: Int, max: Int): ArrayList<Int> {
        val isoArray = intArrayOf(
            50, 64, 80, 100, 125, 160, 200, 250, 320,
            400, 500, 640, 800, 1600, 3200
        )
        val isoList: ArrayList<Int> = ArrayList()
//        isoList.add(50)
//        isoList.add(64)     //14
//        isoList.add(80)     //16
//        isoList.add(100)    //20
//        isoList.add(125)    //25
//        isoList.add(160)    //35
//        isoList.add(200)    //40
//        isoList.add(250)    //50
//        isoList.add(320)    //70
//        isoList.add(400)    //80
//        isoList.add(500)    //100
//        isoList.add(640)    //140
//        isoList.add(800)    //160
//        isoList.add(1600)   //800
//        isoList.add(3200)   //1600

        isoArray.forEach {
            if (it in min until max)
                isoList.add(it)
        }
        return isoList
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getTvList(min: Int, max: Int): ArrayList<Int> {
        val tvArray = intArrayOf(
            24000, 16000, 12000, 8000, 6000, 4000, 3000, 2000, 1500, 1000,
            750, 500, 350, 250, 180, 125, 90, 60, 50, 45, 30, 20, 15, 10
        )
        val tvList: ArrayList<Int> = ArrayList()
//        tvList.add(24000)
//        tvList.add(16000)   //8000
//        tvList.add(12000)   //6000
//        tvList.add(8000)    //4000
//        tvList.add(6000)    //2000
//        tvList.add(4000)    //2000
//        tvList.add(3000)    //1000
//        tvList.add(2000)    //1000
//        tvList.add(1500)    //500
//        tvList.add(1000)    //500
//        tvList.add(750)     //250
//        tvList.add(500)     //250
//        tvList.add(350)     //150
//        tvList.add(250)     //100
//        tvList.add(180)     //70
//        tvList.add(125)     //55
//        tvList.add(90)      //35
//        tvList.add(60)      //30
//        tvList.add(50)      //30
//        tvList.add(45)      //15
//        tvList.add(30)      //15
//        tvList.add(20)      //10
//        tvList.add(15)      //5
//        tvList.add(10)      //5
//        tvList.add(8)       //2
//        tvList.add(6)       //2
//        tvList.add(4)       //2
//        tvList.add(3)       //0.3
//        tvList.add(2)       //0.5
//        tvList.add(1)
//        tvList.add(2)
//        tvList.add(4)
//        tvList.add(8)
//        tvList.add(10)
//        tvList.add(15)
//        tvList.add(30)
        tvArray.forEach {
            if (it in min until max)
                tvList.add(it)
        }
        return tvList
    }
}
