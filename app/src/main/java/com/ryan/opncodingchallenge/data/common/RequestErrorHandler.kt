package com.ryan.opncodingchallenge.data.common

import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

object RequestErrorHandler {
    private const val HTTP_CODE_CLIENT_START = 400
    private const val HTTP_CODE_CLIENT_END = 499
    private const val HTTP_CODE_SERVER_START = 500
    private const val HTTP_CODE_SERVER_END = 599

    fun getRequestError(throwable: Throwable): RemoteSourceException {
        return when (throwable) {
            is HttpException -> {
                handleHttpException(throwable)
            }

            is SocketTimeoutException -> {
                RemoteSourceException.Timeout("Request Time Out!")
            }

            is IOException -> {
                RemoteSourceException.Connection("Connection Error")
            }

            else -> {
                RemoteSourceException.Unexpected("Unexpected Error Occurred")
            }
        }
    }

    private fun handleHttpException(httpException: HttpException): RemoteSourceException {
        return when (httpException.code()) {
            in HTTP_CODE_CLIENT_START..HTTP_CODE_CLIENT_END -> {
                RemoteSourceException.Client("Unexpected Client Error Occurred!")
            }

            in HTTP_CODE_SERVER_START..HTTP_CODE_SERVER_END -> {
                RemoteSourceException.Server("Can't connect to error")
            }

            else -> {
                RemoteSourceException.Unexpected("Unexpected Error Occurred!")
            }
        }
    }
}

sealed class RemoteSourceException(val messageResource: Any?) : RuntimeException() {
    class Connection(messageResource: String) : RemoteSourceException(messageResource)
    class Unexpected(messageResource: String) : RemoteSourceException(messageResource)
    class Timeout(messageResource: String) : RemoteSourceException(messageResource)
    class Client(messageResource: String) : RemoteSourceException(messageResource)
    class Server(messageResource: Any?) : RemoteSourceException(messageResource)
}