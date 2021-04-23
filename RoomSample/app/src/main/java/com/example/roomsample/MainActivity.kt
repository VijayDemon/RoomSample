package com.example.roomsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomsample.database.Sample
import com.example.roomsample.database.SampleData
import com.example.roomsample.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var data: List<Sample>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var INPUT: EditText = binding.inputValue
        var ADD: Button = binding.add
        var DELETE: Button = binding.clear

        val application = requireNotNull(this).application
        val dataSource = SampleData.getInstance(application).SampleDao
        val viewModelFactory = MainViewModelFactory(dataSource)
        val mainViewModel: MainViewModel =
                ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        ADD.setOnClickListener {
            Toast.makeText(this, "Added", Toast.LENGTH_LONG).show()

            val str = INPUT.text.toString()
            mainViewModel.insert(str)
            mainViewModel.getData()
            binding.inputValue.setText("")


        }
        DELETE.setOnClickListener {

            Toast.makeText(this, "Cleared", Toast.LENGTH_LONG).show()
            mainViewModel.delete()
            data = listOf()
            showData()
        }

         mainViewModel.state.observe(this, Observer {


            if (it == true) {
                data = mainViewModel.data!!
                mainViewModel.state.value = false
                showData()
            }
            mainViewModel.getData()
    })
        mainViewModel.getData()
    }
    private fun showData() {
        val layout = binding.linearlayout
        layout.removeAllViews()

        data.forEach {
            val textView = TextView(this)
            textView.setText(it.sampleName)
            textView.setPadding(20, 20, 20, 20)
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24.2F)
            layout.addView(textView)

        }

    }
}
