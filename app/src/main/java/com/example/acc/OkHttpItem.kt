package com.example.okhttp3

import java.util.*

data class OkHttpItem(
    @SerializedName("rendered_body") val rendered_body : String,
    @SerializedName("body") val body : String,
    @SerializedName("coediting") val coediting : Boolean,
    @SerializedName("comments_count") val comments_count : Int,
    @SerializedName("created_at") val created_at : Date,
    @SerializedName("group") val group : String,
    @SerializedName("id") val id : String,
    @SerializedName("likes_count") val likes_count : Int,
    @SerializedName("private") val private : Boolean,
    @SerializedName("reactions_count") val reactions_count : Int,
    @SerializedName("tags") val tags : List<Tags>,
    @SerializedName("title") val title : String,
    @SerializedName("updated_at") val updated_at : String,
    @SerializedName("url") val url : String,
    @SerializedName("user") val user : User,
    @SerializedName("page_views_count") val page_views_count : String
)
annotation class SerializedName(val value: String)

data class Tags (

    @SerializedName("name") val name : String,
    @SerializedName("versions") val versions : List<String>
)

data class User (

    @SerializedName("description") val description : String,
    @SerializedName("facebook_id") val facebook_id : String,
    @SerializedName("followees_count") val followees_count : Int,
    @SerializedName("followers_count") val followers_count : Int,
    @SerializedName("github_login_name") val github_login_name : String,
    @SerializedName("id") val id : String,
    @SerializedName("items_count") val items_count : Int,
    @SerializedName("linkedin_id") val linkedin_id : String,
    @SerializedName("location") val location : String,
    @SerializedName("name") val name : String,
    @SerializedName("organization") val organization : String,
    @SerializedName("permanent_id") val permanent_id : Int,
    @SerializedName("profile_image_url") val profile_image_url : String,
    @SerializedName("team_only") val team_only : Boolean,
    @SerializedName("twitter_screen_name") val twitter_screen_name : String,
    @SerializedName("website_url") val website_url : String
)