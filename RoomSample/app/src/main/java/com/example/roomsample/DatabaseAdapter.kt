package com.example.roomsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomsample.database.Sample
import com.example.roomsample.database.SampleData

class DatabaseAdapter(private val context: Context?, private val data: List<Sample>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.data_in_database,parent,false) as TextView
            return TextItemViewHolder(view)
    }


    override fun getItemCount(): Int {
        return data.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val textVal = holder.itemView.findViewById<TextView>(R.id.text_view1)
        textVal.text = data[position].sampleName
    }

    class TextItemViewHolder(v :View?) :RecyclerView.ViewHolder(v!!){

        val tittle = itemView.findViewById<TextView>(R.id.text_view1)
    }


}