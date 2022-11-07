package com.example.lab6

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("請選擇功能")
            dialog.setMessage("請根據下方按鈕選擇要顯示的物件")
            dialog.setNeutralButton("取消") { dialog, which -> Toast.makeText(this@MainActivity, "dialog關閉", Toast.LENGTH_SHORT).show() }
            dialog.setNegativeButton("自訂義Toast") { dialog, which -> showToast() }
            dialog.setPositiveButton("顯示list") { dialog, which -> showListDialog() }
            dialog.show()
        }
    }

    private fun showToast() {
        //宣告 Toast
        val toast = Toast(this)
        //Toast 在畫面中顯示位置
        toast.setGravity(Gravity.TOP, 0, 50)
        //Toast 在畫面中顯示的持續時間
        toast.duration = Toast.LENGTH_SHORT
        //放入自定義的畫面 custom_toast.xml
        toast.view =
            layoutInflater.inflate(R.layout.custom_toast, null)
        toast.show()
    }

    private fun showListDialog() {
        val list = arrayOf("messsage1", "messsage2", "messsage3", "messsage4", "messsage5")
        val dialog_list = AlertDialog.Builder(this@MainActivity)
        dialog_list.setTitle("使用LIST呈現")
        dialog_list.setItems(list) { dialog, i -> Toast.makeText(this@MainActivity, "你選得是" + list[i], Toast.LENGTH_SHORT).show() }
        dialog_list.show()
    }
}