package com.example.roomsample
 import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomsample.database.Sample
import com.example.roomsample.database.SampleDao
import kotlinx.coroutines.*


class MainViewModel ( private val database: SampleDao): ViewModel(){

    private val viewModelJob = Job()
    private  val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val state = MutableLiveData<Boolean>()
    init {
        state.value = false
    }
    var data: List<Sample>?=null
    fun  insert ( str :String){
        uiScope.launch{
            withContext(Dispatchers.IO){
                var sampleData= Sample()
                sampleData.sampleName=str
                database.insert(sampleData)
            }
        }
    }
    fun delete (){
        uiScope.launch {
            withContext(Dispatchers.IO){
                database.clear()
            }
        }
    }



    fun getData (){
        uiScope.launch {
            withContext(Dispatchers.IO){
            data = database.getAllTasks()
            }
            state.value = true
        }

        }
}


