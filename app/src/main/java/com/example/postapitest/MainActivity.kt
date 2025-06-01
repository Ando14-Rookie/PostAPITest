package com.example.postapitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var textName:TextView
    private lateinit var textJob:TextView
    private lateinit var textID:TextView
    private lateinit var textCreated:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textName = findViewById(R.id.textName)
        textJob = findViewById(R.id.textJob)
        textID = findViewById(R.id.textID)
        textCreated = findViewById(R.id.textCreated)

        val myAPI = Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIFunction::class.java)

        myAPI.createEmployee("reqres-free-v1", RequestBody1("Morpheus","leader")).enqueue(object :Callback<ResponseBody11>{
            override fun onResponse(call: Call<ResponseBody11>, response: Response<ResponseBody11>) {
                if(response.isSuccessful){
                    Log.i("CheckDone","Response to $response")
                    textName.text = response.body()?.name
                    textJob.text = response.body()?.job.toString()
                    textID.text = response.body()?.id.toString()
                    textCreated.text = response.body()?.createdAt.toString()
                    Toast.makeText(applicationContext, "${response.body()?.name} and ${response.body()?.job} is SENT",
                                   Toast.LENGTH_LONG).show()
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