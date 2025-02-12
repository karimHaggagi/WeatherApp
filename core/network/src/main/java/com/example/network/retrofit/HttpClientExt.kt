package com.example.network.retrofit

import android.util.Log
import com.example.common.*
import kotlinx.coroutines.ensureActive
import retrofit2.Response
import java.net.SocketTimeoutException
import java.nio.channels.UnresolvedAddressException
import kotlin.coroutines.coroutineContext
/**
 * created by Karim Haggagi on 11/19/24
 **/

suspend inline fun <reified T> safeCall(execute: () -> Response<T>): Result<T, DataError.Remote> {
    val response = try {
        execute()
    } catch (e: SocketTimeoutException) {
        return Result.Error(DataError.Remote.REQUEST_TIMEOUT)
    } catch (e: UnresolvedAddressException) {
        return Result.Error(DataError.Remote.NO_INTERNET)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        Log.e("safeCall", e.message.toString())
        return Result.Error(DataError.Remote.UNKNOWN)
    }
    return responseToResult(response)
}

suspend inline fun <reified T> responseToResult(response: Response<T>): Result<T, DataError.Remote> {
    return when (response.code()) {
        in 200..299 -> {
            try {
                val body = response.body()
                if (body != null) {
                    Result.Success(body)
                } else {
                    Result.Error(DataError.Remote.SERIALIZATION)
                }
            } catch (e: Exception) {
                Result.Error(DataError.Remote.SERIALIZATION)
            }
        }

        408 -> Result.Error(DataError.Remote.REQUEST_TIMEOUT)
        429 -> Result.Error(DataError.Remote.TOO_MANY_REQUESTS)
        in 500..599 -> Result.Error(DataError.Remote.SERVER)
        else -> Result.Error(DataError.Remote.UNKNOWN)
    }

}