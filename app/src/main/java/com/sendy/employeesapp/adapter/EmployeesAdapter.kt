package com.sendy.employeesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sendy.employeesapp.R
import com.sendy.employeesapp.model.EmployeesModel
import kotlinx.android.synthetic.main.recycler_layout.view.*

class EmployeesAdapter(internal var context: Context, internal var empList: List<EmployeesModel>):
    RecyclerView.Adapter<EmployeesAdapter.EmployeesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.recycler_layout, parent, false)
        return EmployeesViewHolder(view)
    }

    override fun getItemCount(): Int {

        return empList.size
    }

    override fun onBindViewHolder(holder: EmployeesAdapter.EmployeesViewHolder, position: Int) {

        val (id, employee_name, employee_salary, employee_age, profile_image) = empList[position]

        Glide.with(context)
            .load(profile_image)
            .into(holder.profile_image)

        holder.id.text = id.toString()
        holder.name.text = employee_name
        holder.salary.text = employee_salary
        holder.age.text = employee_age

    }

    inner class EmployeesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val profile_image: ImageView
        val id: TextView
        val name: TextView
        val salary: TextView
        val age: TextView

        init {
            id = itemView.findViewById(R.id.tvId)
            name = itemView.findViewById(R.id.tvName)
            salary = itemView.findViewById(R.id.tvSalary)
            age = itemView.findViewById(R.id.tvAge)
            profile_image = itemView.findViewById(R.id.ivProfilePic)

        }
    }

}