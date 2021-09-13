package com.example.prjin_servtechvenger.core.model.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.Spinner
import com.example.prjin_servtechvenger.core.model.Services

class servicesAdaptor(val services: ArrayList<Services>): Spinner.Adapter<servicesAdaptor.Viewholder>() {
    var onItemClick : ((Services)->Unit)?=null
    override fun OnCreateViewHolder(parent: ViewGroup, viewType: Int):servicesAdaptor.ViewHolder{
        val v= LayoutInflater.from(parent.context).inflate(R.layout.)
    }
}
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import co.za.mtn.academy.itsgotime.R
//import co.za.mtn.academy.itsgotime.core.model.User
//
//class UserAdapter(val users: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
//
//    var onItemClick: ((User) -> Unit)? = null
//
//    // this method is returning the view for each item in the list
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
//        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_users_layout_item, parent, false)
//        return ViewHolder(v)
//    }
//
//    // this method is binding the data on the list
//    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
//        holder.bindItems(users[position])
//    }
//
//    // this method is returning the size of the list
//    override fun getItemCount(): Int {
//        return users.size
//    }