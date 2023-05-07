package com.example.kotlinmvvmapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.WARN
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvmapi.adapter.ProductAdapter
import com.example.kotlinmvvmapi.viewmodels.MainViewModel
import com.example.kotlinmvvmapi.viewmodels.MainViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import okhttp3.internal.platform.Platform.WARN
import javax.inject.Inject

class MainActivity : AppCompatActivity(){
    private lateinit var productList: RecyclerView
    lateinit var mainViewModel: MainViewModel

    @Inject
   lateinit var mainViewModelFactory : MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as FackerApplication).applicationComponent.inject(this)
        mainViewModel = ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)

        productList =findViewById(R.id.rVResult)
        productList.layoutManager = LinearLayoutManager(this)
        mainViewModel.getProducts()

        observeCharactetrList()
    }

    private fun observeCharactetrList() {
        mainViewModel.productLiveData.observe(this) {

            productList.adapter = ProductAdapter(it,this@MainActivity)
        }
    }
}