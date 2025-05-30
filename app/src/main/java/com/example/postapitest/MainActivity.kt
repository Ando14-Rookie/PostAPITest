package com.example.postapitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text123)
        val myAPI = Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIFunction::class.java)

        myAPI.createEmployee("reqres-free-v1", RequestBody1("Morpheous","leader")).enqueue(object :Callback<ResponseBody11>{
            override fun onResponse(call: Call<ResponseBody11>, response: Response<ResponseBody11>) {
                if(response.isSuccessful){
                    Log.i("CheckDone","Response to $response")
                    textView.text = response.body()?.name
                    Toast.makeText(applicationContext, "$response is SUCCESSFUL", Toast.LENGTH_LONG).show()
                }
                else{
                    Log.i("API Response", response.toString())
                }
            }

            override fun onFailure(call: Call<ResponseBody11>, t: Throwable) {
                Log.e("ErrorOccurred", "Error due to $t")
            }

        })
    }
}