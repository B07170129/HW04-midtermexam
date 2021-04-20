package com.example.midtermexam

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MyAdapter
    private val contacts = ArrayList<Contact>()
    //接收回傳資料
    override fun onActivityResult(requestCode: Int, resultCode: Int, data:
    Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
                val name = it.getString("name") ?: return@let
                val te = it.getString("te") ?: return@let
                var photos=0
                if(name=="apple"){
                    var photo1 = Photo(R.drawable.apple)
                    contacts.add(Contact(name, te, photo1))
                }else if(name=="avocado"){
                    var photo2 = Photo(R.drawable.avocado)
                    contacts.add(Contact(name, te, photo2))
                }else if(name=="banana"){
                    var photo3 = Photo(R.drawable.banana)
                    contacts.add(Contact(name, te, photo3))
                }else if(name=="cherries"){
                    var photo4 = Photo(R.drawable.cherries)
                    contacts.add(Contact(name, te, photo4))
                }else if (name=="coconut"){
                    var photo5 = Photo(R.drawable.coconut)
                    contacts.add(Contact(name, te, photo5))
                }
                //更新列表
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                val linearLayoutManager = LinearLayoutManager(this)
                linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
                recyclerView.layoutManager = linearLayoutManager
                adapter = MyAdapter(contacts)
                recyclerView.adapter = adapter

                //val recyclerView2 = findViewById<RecyclerView>(R.id.recyclerView)
                //recyclerView2.layoutManager = LinearLayoutManager(this)
                //recyclerView2.setHasFixedSize(true)
                //recyclerView2.adapter = PhotoAdapter(this,photos)
                //更新列表
                adapter.notifyDataSetChanged()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //將變數與 XML 元件綁定
        val btn_add = findViewById<Button>(R.id.btn_add)
        //創建 LinearLayoutManager 物件，設定垂直排列

        //創建 MyAdapter 並連結 recyclerView

        //設定按鈕監聽器，使用 startActivityForResult()啟動 SecActivity
        btn_add.setOnClickListener {
            startActivityForResult(Intent(this, SecActivity::class.java), 1)
        }
    }
}

//設計新的類別定義聯絡人的資料結構
data class Contact (

    val name: String, //姓名
    val te: String, //電話
    var photo2: Photo
)