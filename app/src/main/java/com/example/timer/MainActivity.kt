package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

    }

    fun StartTime(view: View) {
        val ButtonOne: Button = findViewById(R.id.StartStop)
        var Sec: TextView = findViewById(R.id.Sec)
        var Minutes: TextView = findViewById(R.id.Minutes)
        var Hour: TextView = findViewById(R.id.Hour)
        val toastText = "End Hours: ${Hour.text} Minutes: ${Minutes.text} Sec: ${Sec.text}"
        var toast: Toast = Toast.makeText(applicationContext, toastText, LENGTH_LONG)
        var checkEnd: Boolean = true
        if (ButtonOne.text == "START" && (Sec.text.toString()
                .toInt() != 0 || Minutes.text.toString().toInt() != 0 || Hour.text.toString()
                .toInt() != 0)
        ) {
            ButtonOne.setText("STOP")
            while (checkEnd) {
                if (Sec.text.toString().toInt() != 0) {
                    SystemClock.sleep(1000)
                    Sec.setText("${(Sec.text.toString().toInt() - 1)}")
                }
                if (Sec.text.toString().toInt() == 0 && Minutes.text.toString().toInt() != 0) {
                    Minutes.setText("${Minutes.text.toString().toInt() - 1}")
                    Sec.setText("60")
                }
                if (Sec.text.toString().toInt() == 0 && Hour.text.toString().toInt() != 0) {

                    Hour.setText("${Hour.text.toString().toInt() - 1}")
                    Minutes.setText("60")
                }
                if(Sec.text.toString().toInt() == 0 && Hour.text.toString().toInt() == 0 && Minutes.text.toString().toInt() == 0) {
                    ButtonOne.setText("START")
                    toast.show()
                    checkEnd = false
                }
            }

        }
    }
}