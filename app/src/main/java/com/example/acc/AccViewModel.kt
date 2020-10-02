package com.example.acc

import androidx.lifecycle.MutableLiveData
import com.example.okhttp3.OkHttpItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import java.util.logging.Handler

class AccViewModel : BaseViewModel() {

    val items = MutableLiveData<List<OkHttpItem>>()
    val isShownProgress = MutableLiveData<Boolean>()
    private val handler = android.os.Handler()
    var page = 1


    fun initData() {
        showProgress()
        updataData()
    }

    fun updataData() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://qiita.com/api/v2/items?page=${page}&per_page=20")
            .build()
        client.run {
            newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    hideProgress()
                    updateResult(listOf())
                }

                override fun onResponse(call: Call, response: Response) {
                    hideProgress()
                    response.body?.string()?.also {
                        val gson = Gson()
                        val type = object : TypeToken<List<OkHttpItem>>() {}.type
                        val list = gson.fromJson<List<OkHttpItem>>(it, type)
                        updateResult(list)
                    } ?: run {
                        updateResult(listOf())
                    }
                }
            })
        }
    }

    private fun updateResult(list: List<OkHttpItem>) {
        items.postValue(list) // 非同期もOK [MainThread以外からもOK]
    }

    private fun showProgress() {
        isShownProgress.postValue(true)
    }

    private fun hideProgress() {
        isShownProgress.postValue(false)
    }
}

