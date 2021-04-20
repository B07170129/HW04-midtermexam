package com.example.midtermexam

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)
        //將變數與 XML 元件綁定
        val btn_send = findViewById<Button>(R.id.btn_send)
        val ed_name = findViewById<EditText>(R.id.ed_name)
        val ed_te = findViewById<EditText>(R.id.ed_te)
        //設定按鈕監聽器
        btn_send.setOnClickListener {
            //判斷是否輸入資料
            when {
                ed_name.length() < 1 -> showToast("請輸入水果名")
                ed_te.length() < 1 -> showToast("請輸入介紹")
                else -> {
                    val b = Bundle()
                    b.putString("name", ed_name.text.toString())
                    b.putString("te", ed_te.text.toString())
                    //使用 setResult()回傳聯絡人資料
                    setResult(Activity.RESULT_OK, Intent().putExtras(b))
                    finish()
                }
            }
        }
    }
    //建立 showToast 方法顯示 Toast 訊息
    private fun showToast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}