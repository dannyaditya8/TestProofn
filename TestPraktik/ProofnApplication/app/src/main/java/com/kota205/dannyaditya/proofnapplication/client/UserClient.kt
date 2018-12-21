package com.kota205.dannyaditya.proofnapplication.client

import com.kota205.dannyaditya.proofnapplication.model.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface UserClient {

    @FormUrlEncoded
    @POST("auth/login")
    fun userLogin(@Header("Content-Type") headerContent: String,
                  @Field("identifier") identifier: String,
                  @Field("password") password: String) : Call<Void>
}