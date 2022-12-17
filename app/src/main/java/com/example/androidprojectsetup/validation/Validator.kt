package com.example.androidprojectsetup.validation

interface Validator {
    fun isValid(): Boolean
    fun message(): String?
}