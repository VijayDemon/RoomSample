package com.example.roomsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomsample.database.SampleDao
import java.lang.IllegalArgumentException
import javax.sql.DataSource


class MainViewModelFactory(

    private val dataSource: SampleDao): ViewModelProvider.Factory{

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if ( modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(dataSource) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel Class")
    }
}
