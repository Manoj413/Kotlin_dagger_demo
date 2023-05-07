package com.example.kotlinmvvmapi.viewmodels

import com.example.kotlinmvvmapi.models.Product
import com.example.kotlinmvvmapi.repository.MainCoroutineRule
import com.example.kotlinmvvmapi.repository.ProductRespository
import com.example.kotlinmvvmapi.utils.ResponseApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.kotlinmvvmapi.di.NetworkModule

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

   /* @get:Rule
    val mainCoroutineRule = MainCoroutineRule()
*/
    val testDispatcher = StandardTestDispatcher()


    @Mock
    lateinit var productRespository:ProductRespository

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun testGetProducts() = runTest{

        Mockito.`when`(productRespository.getProducts()).thenReturn(ResponseApi.Success(emptyList()))
        val sut = MainViewModel(productRespository)
        sut.getProducts()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = sut.productLiveData
        Assert.assertEquals(0, result.value!!.size)
        //Assert.assertEquals(0, 0)
    }

    @Test
    fun testGetProducts_expectedError()= runTest {
        Mockito.`when`(productRespository.getProducts()).thenReturn(ResponseApi.Error("Something went wrong"))
        val sut = MainViewModel(productRespository)
        sut.getProducts()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = sut.productLiveData
        Assert.assertEquals("Something went wrong",result.value?.toString())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
