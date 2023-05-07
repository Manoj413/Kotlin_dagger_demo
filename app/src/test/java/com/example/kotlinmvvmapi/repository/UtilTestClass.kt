package com.example.kotlinmvvmapi.repository

import com.example.kotlinmvvmapi.utils.Util
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UtilTestClass {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Test
    fun getUserList(){
        val util = Util(mainCoroutineRule.testDispatcher)

         runTest{
            util.getAddressDetail()
             mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
             Assert.assertEquals(true,util.getAddressDetail())
        }

    }


}