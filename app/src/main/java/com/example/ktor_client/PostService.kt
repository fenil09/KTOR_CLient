package com.example.ktor_client

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.kotlinx.serializer.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

interface PostService {
    suspend fun getposts(): List<PostResponse>

    companion object{
        fun createKtor():PostService{
            return postServiceImplementation(
                ktorclient = HttpClient(Android){
                    install(ContentNegotiation){
                        json(Json{
                            ignoreUnknownKeys= true
                            prettyPrint =true
                            isLenient =true
                        })
                    }
                }
            )
        }
    }
}

