package com.example.mobileapp44

import android.app.Application
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class BookApplication:Application() {
    public lateinit var books: ApiInterface
    override fun onCreate() {
        super.onCreate()
        books=bookService()
    }
    private fun bookService():ApiInterface
    {
        val retrofit= Retrofit.Builder()
            .baseUrl("https://httpapibooks.mocklab.io/")
            .addConverterFactory(JacksonConverterFactory.create(ObjectMapper()))
            .build()
        return retrofit.create(ApiInterface::class.java)
    }
}