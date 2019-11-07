package com.sendy.employeesapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sendy.employeesapp.R
import com.sendy.employeesapp.adapter.EmployeesAdapter
import com.sendy.employeesapp.viewmodel.EmployeesViewModel

class MainActivity : AppCompatActivity() {
    var employeesViemodel: EmployeesViewModel? = null
    var recyclerView: RecyclerView? = null
    var adapter: EmployeesAdapter? = null
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = linearLayoutManager

        employeesViemodel = ViewModelProviders.of(this).get(EmployeesViewModel::class.java)

        employeesViemodel!!.listOfEmployees()?.observe(this, Observer {

            observedEmployeesList -> adapter = EmployeesAdapter(this, observedEmployeesList)

            recyclerView!!.adapter = adapter

        })
    }
}