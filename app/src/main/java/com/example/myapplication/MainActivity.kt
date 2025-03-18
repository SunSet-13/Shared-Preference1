package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class MainActivity : ComponentActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvUsername: TextView
    private lateinit var tvPassword: TextView
    private lateinit var btnSave: Button
    private lateinit var btnShow: Button
    private lateinit var btnClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        // Ánh xạ View
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        tvUsername = findViewById(R.id.tvUsername)
        tvPassword = findViewById(R.id.tvPassword)
        btnSave = findViewById(R.id.btnSave)
        btnShow = findViewById(R.id.btnShow)
        btnClear = findViewById(R.id.btnClear)

        // Xử lý sự kiện khi nhấn nút "Lưu"
        btnSave.setOnClickListener {
            val name = etUsername.text.toString()
            val pass = etPassword.text.toString()
            //luu gia tri nay vao sharedpreferences
            val sharedPreferences = getSharedPreferences("ANHYEUEM", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val editor2 = sharedPreferences.edit()
            editor.putString("Name",name)
            editor2.putString("Pass",pass)
            editor.apply()
            editor2.apply()
        }
        // Xử lý sự kiện khi nhấn nút "Hiển thị"
        btnShow.setOnClickListener {
            val sharedPreferences = getSharedPreferences("ANHYEUEM", MODE_PRIVATE)
            val name = sharedPreferences.getString("Name", "")
            val pass = sharedPreferences.getString("Pass", "")
            tvUsername.text = "Tên người dùng: $name"
            tvPassword.text = "Mật khẩu: $pass"
        }
        // Xử lý sự kiện khi nhấn nút "Xóa"
        btnClear.setOnClickListener {
            val sharedPreferences = getSharedPreferences("ANHYEUEM", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            tvUsername.text = ""
            tvPassword.text = ""
        }



    }
}
