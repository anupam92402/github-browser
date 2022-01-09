package com.example.githubbrowser

import com.example.githubbrowser.models.RepoModal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Url

interface RetrofitApi {

    @Headers("Accept: application/vnd.github.v3+json")
    @GET
    fun getRepo(@Url url: String): Call<RepoModal> //return repo of user
}