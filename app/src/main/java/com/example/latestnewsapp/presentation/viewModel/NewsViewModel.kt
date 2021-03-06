package com.example.latestnewsapp.presentation.viewModel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.latestnewsapp.data.model.Article
import com.example.latestnewsapp.data.model.NewsResponse
import com.example.latestnewsapp.data.util.Resource
import com.example.latestnewsapp.domain.useCase.*
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: SearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsUseCase: GetSavedNewsUseCase,
    private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase
): AndroidViewModel(app) {
    val newsHeadLines: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()


    fun getNewsHeadlines(country: String,page: Int) = viewModelScope.launch {
        newsHeadLines.postValue(Resource.Loading())
        try {
            if(isNetworkAvailable(app)){
                val result = getNewsHeadlinesUseCase.execute(country,page)
                newsHeadLines.postValue(result)
            }else{
                newsHeadLines.postValue(Resource.Error("Internet is not available"))
            }
        }catch (e: Exception){
            newsHeadLines.postValue(Resource.Error(e.message.toString()))
        }
    }

    val searchedHeadlines: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()

    fun getSearchedNewsHeadlines(country: String,searchedQuery: String,page: Int) = viewModelScope.launch {
        searchedHeadlines.postValue(Resource.Loading())
        try {
            if(isNetworkAvailable(app)){
                val result = getSearchedNewsUseCase.execute(country,searchedQuery,page)
                searchedHeadlines.postValue(result)
            }else{
                searchedHeadlines.postValue(Resource.Error("Internet is not available"))
            }
        }catch (e: Exception){
            searchedHeadlines.postValue(Resource.Error(e.message.toString()))
        }
    }



    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }


    //Local Database
    fun saveArticle(article: Article) = viewModelScope.launch{
        saveNewsUseCase.execute(article)
    }

    fun deleteNews(article: Article) = viewModelScope.launch {
        deleteSavedNewsUseCase.execute(article)
    }

    fun getSavedArticle() = liveData {
        getSavedNewsUseCase.execute().collect{
            emit(it)
        }
    }


}