package com.example.roomsample.database

import androidx.room.*


@Dao
interface  SampleDao{


    @Insert
    fun insert (sample: Sample)

    @Query ("DELETE FROM sample_data")
    suspend fun clear()


    @Query ("SELECT * FROM sample_data ORDER BY sampleId DESC")
    suspend fun getAllTasks() : List<Sample>?

}












//
//@Database (entities = [Sample::class],version = 1,exportSchema = false)
//abstract class SampleDao :RoomDatabase() {
//
//    companion object{
//
//        private var INSTANCE :SampleData ?=null
//
//        fun getInstance(context : Context) :SampleData{
//
//            synchronized(this){
//
//                var instance = INSTANCE
//                if(  instance == null){
//                    instance = Room.databaseBuilder(context.applicationContext,SampleData::class.java,"sample_database").fallbackToDestructiveMigration().build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//    }
//}