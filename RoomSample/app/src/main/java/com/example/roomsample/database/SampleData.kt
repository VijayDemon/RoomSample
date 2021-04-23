package com.example.roomsample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Sample::class],version = 1,exportSchema = false)

abstract class SampleData :RoomDatabase() {
    abstract  val SampleDao:SampleDao

    companion object{

        @Volatile
        private var INSTANCE :SampleData ?=null

        fun getInstance(context : Context) :SampleData{

            synchronized(this){

                var instance = INSTANCE
                if(  instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,SampleData::class.java,"sample_database").
                    fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
