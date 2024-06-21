package com.example.ktor_client

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.Serializable

class postServiceImplementation(
    private val ktorclient:HttpClient
):PostService {
    override suspend fun getposts(): List<PostResponse> {
        val response:HttpResponse= ktorclient.get {
            url(HttpRoutes.POSTS)
        }
        return response.body<List<PostResponse>>()
    }
}