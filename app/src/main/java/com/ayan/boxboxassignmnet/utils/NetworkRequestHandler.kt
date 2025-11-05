package com.ayan.boxboxassignmnet.utils

import retrofit2.Response
import java.net.SocketTimeoutException

suspend fun<DTO,DOMAIN_MODEL> safeApiCall(
    apiCall: suspend ()-> Response<DTO>,
    mapSuccess: (DTO)->DOMAIN_MODEL
): Result<DOMAIN_MODEL>{
    return try {
        val response = apiCall()
        if (response.isSuccessful){
            val body = response.body()!!
            Result.success(mapSuccess(body))
        } else {
            Result.failure(Exception("Unknown error occurs.."))
        }
    } catch (e: SocketTimeoutException){
        Result.failure(Exception("Can't reach the server.."))
    } catch (e: Exception){
        Result.failure(Exception(e.localizedMessage))
    }
}