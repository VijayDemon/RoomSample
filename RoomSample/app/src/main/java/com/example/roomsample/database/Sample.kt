package com.example.roomsample.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "sample_data")
data class Sample (
    @PrimaryKey(autoGenerate = true)
    var sampleId :Long=0L,
    @ColumnInfo(name="sampleName")
    var sampleName :String =""
)


