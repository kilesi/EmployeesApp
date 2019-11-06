package com.sendy.employeesapp.network

import com.sendy.employeesapp.model.EmployeesModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("employees")
    fun getAllEmployeesList(): Call<List<EmployeesModel>>
}