package com.example.androidprojectsetup.networkcalls

import androidx.annotation.Keep

@Keep
data class BaseResponse<M>(
    val success: Boolean? = null,
    val data: M? = null,
    val message: String? = null,

)
