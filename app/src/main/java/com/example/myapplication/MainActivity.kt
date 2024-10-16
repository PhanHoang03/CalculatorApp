package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textReuslt: TextView

    var state: Int = 1
    var op: Int = 0
    var op1: Int = 0
    var op2: Int = 0
    var op3: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textReuslt = findViewById(R.id.txtResult)

        findViewById<Button>(R.id.btn0).setOnClickListener(this)
        findViewById<Button>(R.id.btn1).setOnClickListener(this)
        findViewById<Button>(R.id.btn2).setOnClickListener(this)
        findViewById<Button>(R.id.btn3).setOnClickListener(this)
        findViewById<Button>(R.id.btn4).setOnClickListener(this)
        findViewById<Button>(R.id.btn5).setOnClickListener(this)
        findViewById<Button>(R.id.btn6).setOnClickListener(this)
        findViewById<Button>(R.id.btn7).setOnClickListener(this)
        findViewById<Button>(R.id.btn8).setOnClickListener(this)
        findViewById<Button>(R.id.btn9).setOnClickListener(this)
        findViewById<Button>(R.id.btnAdd).setOnClickListener(this)
        findViewById<Button>(R.id.btnDiv).setOnClickListener(this)
        findViewById<Button>(R.id.btnMul).setOnClickListener(this)
        findViewById<Button>(R.id.btnSub).setOnClickListener(this)
        findViewById<Button>(R.id.btnEqual).setOnClickListener(this)
        findViewById<Button>(R.id.btnC).setOnClickListener(this)
        findViewById<Button>(R.id.btnCE).setOnClickListener(this)
        findViewById<Button>(R.id.btnFlip).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        if (id == R.id.btn0) {
            addDigit(0)
        } else if (id == R.id.btn1) {
            addDigit(1)
        } else if (id == R.id.btn2) {
            addDigit(2)
        } else if (id == R.id.btn3) {
            addDigit(3)
        } else if (id == R.id.btn4) {
            addDigit(4)
        } else if (id == R.id.btn5) {
            addDigit(5)
        } else if (id == R.id.btn6) {
            addDigit(6)
        } else if (id == R.id.btn7) {
            addDigit(7)
        } else if (id == R.id.btn8) {
            addDigit(8)
        } else if (id == R.id.btn9) {
            addDigit(9)
        } else if (id == R.id.btnAdd) {
            if (op != 5)
            {
                if (state == 1) op3 = op1
                else {
                    solve()
                }
            }
            op = 1
            state++
        } else if (id == R.id.btnSub) {
            if (op != 5) {
                if (state == 1) op3 = op1
                else {
                    solve()
                }
            }
            op = 2
            state++
        } else if (id == R.id.btnDiv) {
            if (op != 5) {
                if (state == 1) op3 = op1
                else {
                    solve()
                }
            }
            op = 3
            state++
        } else if (id == R.id.btnMul) {
            if (op != 5) {
                if (state == 1) op3 = op1
                else {
                    solve()
                }
            }
            op = 4
            state++
        } else if (id == R.id.btnEqual) {
            solve()
            state++
            op = 5
            textReuslt.text = "$op3"

        } else if (id == R.id.btnFlip) {
            if (state % 2 == 1) {
                op1 = -op1;
                textReuslt.text = "$op1"
            }
            else {
                op2 = -op2;
                textReuslt.text = "$op2"
            }
        } else if (id == R.id.btnCE) {
            if (state % 2 == 1) {
                op1 = 0;
            }
            else {
                op2 = 0;
            }
            textReuslt.text = "0"
        } else if (id == R.id.btnC) {
            state = 1
            op1 = 0
            op2 = 0
            op3 = 0
            op = 0
            textReuslt.text = "0"
        }

    }

    fun addDigit(c: Int) {
        if (state % 2 == 1) {
            op1 = op1 * 10 + c
            textReuslt.text = "$op1"
        } else {
            op2 = op2 * 10 + c
            textReuslt.text = "$op2"
        }
    }

    fun solve() {
        if (op == 1) {
            if (state % 2 == 1) {
                op3 += op1
                op1 = 0
            }
            else {
                op3 += op2
                op2 = 0
            }
        }
        if (op == 2) {
            if (state % 2 == 1) {
                op3 -= op1
                op1 = 0
            }
            else {
                op3 -= op2
                op2 = 0
            }
        }
        if (op == 3) {
            if (state % 2 == 1) {
                op3 /= op1
                op1 = 0
            }
            else {
                op3 /= op2
                op2 = 0
            }
        }
        if (op == 4) {
            if (state % 2 == 1) {
                op3 *= op1
                op1 = 0
            }
            else {
                op3 *= op2
                op2 = 0
            }
        }
    }
}