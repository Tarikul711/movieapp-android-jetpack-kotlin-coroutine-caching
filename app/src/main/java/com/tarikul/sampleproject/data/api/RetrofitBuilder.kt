package com.tos.myapplication.data.api

import android.util.Log
import com.tarikul.sampleproject.data.api.BaseUrl.API_BASE_URL
import com.tos.android_retrofit_mvvm_jetpack_kotlin.MyApplication
import com.tos.android_retrofit_mvvm_jetpack_kotlin.utils.NetworkUtils
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 *Created by tarikul on 5/9/20
 */
object RetrofitBuilder {
    var cacheSize: Long = 5 * 1024 * 1024
    private val TAG = "RetrofitBuilder"
    var HEADER_CACHE_CONTROL: String = "Cache-Control"
    var HEADER_PRAGMA: String = "Pragma"


    var httpClient =
        OkHttpClient.Builder()
            .cache(cache())
            .addInterceptor(httpLoggingInterceptor())
            .addNetworkInterceptor(NetworkInterceptor())
            .addInterceptor(ForceCacheInterceptor())


    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)

    private fun cache(): Cache {
        return Cache(MyApplication.instance.cacheDir, cacheSize)
    }


    private fun httpLoggingInterceptor(): HttpLoggingInterceptor { // will call in the offline mode
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }


    class NetworkInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val response = chain.proceed(chain.request())
            val cacheControl = CacheControl.Builder()
                .maxAge(5, TimeUnit.SECONDS)
                .build()
            return response.newBuilder()
                .removeHeader(HEADER_PRAGMA)
                .removeHeader(HEADER_CACHE_CONTROL)
                .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                .build()
        }
    }

    class OfflineInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            if (!NetworkUtils.hasNetwork(MyApplication.instance.applicationContext)!!) {
                val cacheControl: CacheControl = CacheControl.Builder()
                    .maxStale(7, TimeUnit.DAYS).build()
                Log.e(TAG, "intercept: offline")
                request.newBuilder()
                    .removeHeader(HEADER_PRAGMA)
                    .removeHeader(HEADER_CACHE_CONTROL)
                    .cacheControl(cacheControl)
                    .build()
            }

            return chain.proceed(request)
        }
    }

    class ForceCacheInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val builder: Request.Builder = chain.request().newBuilder()
                .removeHeader(HEADER_PRAGMA)
                .removeHeader(HEADER_CACHE_CONTROL)
            if (!NetworkUtils.hasNetwork(MyApplication.instance.applicationContext)!!) {
                val cacheControl: CacheControl = CacheControl.Builder()
                    .maxStale(7, TimeUnit.DAYS).build()
//                builder.cacheControl(CacheControl.FORCE_CACHE)  // for force cache control
                builder.cacheControl(cacheControl)

            }
            return chain.proceed(builder.build())
        }
    }

}