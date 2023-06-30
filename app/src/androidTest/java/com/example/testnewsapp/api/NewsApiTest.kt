package com.example.testnewsapp.api

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class NewsApiTest : TestCase() {
    @Test
    fun getNewsApiSuccess() {
        val api = NewsApiImplementation.provideApi()
        val test = runBlocking {
            api.getNewsArticles()
        }
        assertEquals(test.isSuccessful, true)
    }

    @Test
    fun getSearchNews() {
        val api = NewsApiImplementation.provideApi()
        val test = runBlocking {
            api.getSearchNews(pageNumber = 1, searchQuery = "bitcoin")
        }
        assertEquals(test.isSuccessful, true)
    }
}