package com.ynavizovskyi.contacts.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ynavizovskyi.contacts.common.BASE_URL
import com.ynavizovskyi.contacts.datastore.remote.ContactsService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    @Named(BASE_URL)
    fun providesBaseUrl(): String {
        return "https://randomuser.me/api/"
    }

    @Provides
    @Singleton
    fun providesConverterFactory(): Converter.Factory {
        val gson = GsonBuilder().setPrettyPrinting().create()
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    @JvmSuppressWildcards
    fun providesOkHttpClient(): OkHttpClient {
        var builder = OkHttpClient
            .Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
        return builder.build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        @Named(BASE_URL) baseUrl: String,
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun providesContactsService(retrofit: Retrofit): ContactsService {
        return retrofit.create(ContactsService::class.java)
    }

}