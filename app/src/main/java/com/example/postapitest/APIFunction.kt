package com.example.postapitest

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface APIFunction {
    @POST("/api/users")
    fun createEmployee(
        @Header("x-api-key") apiKey: String,
        @Body requestBody: RequestBody1): Call<ResponseBody11>

}