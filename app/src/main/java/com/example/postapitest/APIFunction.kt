package com.example.postapitest

import okhttp3.RequestBody
import retrofit2.Response
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST

interface APIFunction {

    @POST("api/users/")
    suspend fun createEmployee(@Body requestBody: RequestBody): Response<ResponseBody>

}