package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var total= 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_tambah.setOnClickListener{
            proccess("tambah")
        }
        btn_kurang.setOnClickListener{
            proccess("kurang")
        }
        btn_kali.setOnClickListener{
            proccess("kali")
        }
        btn_tugas1.setOnClickListener {
            startActivity(Intent(this,PindahHalaman::class.java))
        }
    }

    fun proccess(jenis : String){
        if(!et_val1.text.isEmpty() && !et_val2.text.isEmpty()){
            when(jenis){
                "tambah" ->  total = et_val1.text.toString().toDouble() + et_val2.text.toString().toDouble()
                "kurang" ->  total = et_val1.text.toString().toDouble() - et_val2.text.toString().toDouble()
                "kali" ->  total = et_val1.text.toString().toDouble() * et_val2.text.toString().toDouble()
            }

            Toast.makeText(applicationContext, "Hasil : " + total,Toast.LENGTH_SHORT).show()
        }else{
            if (et_val1.text.isEmpty()){
                et_val1.setError("Field ini harus di isi")
            }
            if (et_val2.text.isEmpty()){
                et_val2.setError("Field ini harus di isi")
            }
        }
    }
}
