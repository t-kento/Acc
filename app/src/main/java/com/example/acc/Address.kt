package com.example.okhttp3
import com.google.gson.annotations.SerializedName


data class Address(
    @SerializedName("message")
    val message: Any,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("status")
    val status: Int
)

data class Result(
    @SerializedName("address1")
    val address1: String,
    @SerializedName("address2")
    val address2: String,
    @SerializedName("address3")
    val address3: String,
    @SerializedName("kana1")
    val kana1: String,
    @SerializedName("kana2")
    val kana2: String,
    @SerializedName("kana3")
    val kana3: String,
    @SerializedName("prefcode")
    val prefcode: String,
    @SerializedName("zipcode")
    val zipcode: String
)