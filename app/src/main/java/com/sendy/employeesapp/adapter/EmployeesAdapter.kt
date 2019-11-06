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

        val (id, name, salary, age, profileImageUrl) = empList[position]

        Glide.with(context)
            .load(profileImageUrl)
            .into(holder.profileImageUrl)

        holder.id.text = id.toString()
        holder.name.text = name
        holder.salary.text = salary
        holder.age.text = age

    }

    inner class EmployeesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val profileImageUrl: ImageView
        val id: TextView
        val name: TextView
        val salary: TextView
        val age: TextView

        init {
            profileImageUrl = itemView.findViewById(R.id.ivProfilePic)
            id = itemView.findViewById(R.id.tvId)
            name = itemView.findViewById(R.id.tvName)
            salary = itemView.findViewById(R.id.tvSalary)
            age = itemView.findViewById(R.id.tvAge)
        }
    }

}