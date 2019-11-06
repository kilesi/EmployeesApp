package com.sendy.employeesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sendy.employeesapp.model.EmployeesModel
import com.sendy.employeesapp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EmployeesViewModel : ViewModel(){
    var employeesList: MutableLiveData<List<EmployeesModel>>? = null

    fun listOfEmployees(): LiveData<List<EmployeesModel>>{
        //prepare observable data for ui (view)
        if (employeesList == null){
            employeesList = MutableLiveData()
            loadEmployees()
        }
return employeesList as MutableLiveData<List<EmployeesModel>>
    }

    fun loadEmployees(){
        val retrofit = Retrofit.Builder()
            .baseUrl("http://dummy.restapiexample.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiClient::class.java)
        val call = api.getAllEmployeesList()

        call.enqueue(object : Callback<List<EmployeesModel>>{
            override fun onFailure(call: Call<List<EmployeesModel>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<EmployeesModel>>,
                response: Response<List<EmployeesModel>>
            ) {

            }

        })
    }
}