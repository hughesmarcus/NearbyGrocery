package com.product.marcus.nearbygrocery.stores.storelist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.product.marcus.nearbygrocery.R

import com.product.marcus.nearbygrocery.models.Result

/**
 * Created by Marcus on 8/15/2017.
 */
class StoreListAdapter(private val context: Context, private val data: List<Result>, private val listener: OnItemClickListener) : RecyclerView.Adapter<StoreListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grocery_list, null)
        view.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.click(data[position], listener)
        holder.name.text = data[position].name
        if (data[position].openingHours?.openNow == true) {
            holder.opentime.text = "Open"
        } else holder.opentime.text = "Closed"


    }


    override fun getItemCount(): Int {
        return data.size
    }


    interface OnItemClickListener {
        fun onClick(Item: Result)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var name: TextView
        internal var opentime: TextView


        init {
            name = itemView.findViewById<TextView>(R.id.name)
            opentime = itemView.findViewById<TextView>(R.id.opentime)


        }


        fun click(result: Result, listener: OnItemClickListener) {
            itemView.setOnClickListener { listener.onClick(result) }
        }
    }
}