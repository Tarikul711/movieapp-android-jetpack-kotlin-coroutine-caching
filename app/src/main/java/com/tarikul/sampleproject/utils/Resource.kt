package com.tos.androidlivedataviewmodel.projectOne.utils

/**
 *Created by tarikul on 20/9/20
 */

data class Resource<out T>(var status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> =
            Resource(status = Status.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String?): Resource<T> =
            Resource(status = Status.ERROR, data = data, message = message)


        fun <T> loading(data: T?): Resource<T> =
            Resource(status = Status.ERROR, data = data, message = null)

    }
}