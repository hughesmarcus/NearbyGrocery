package com.product.marcus.nearbygrocery.GroceryList.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.product.marcus.nearbygrocery.R
import com.product.marcus.nearbygrocery.database.Item
import com.product.marcus.nearbygrocery.models.Result
import com.product.marcus.nearbygrocery.stores.storelist.StoreListAdapter

/**
 * Created by Marcus on 9/28/2017.
 */
class GroceryListAdapter(private val context: Context, private val items: List<Item>, private val listener: OnItemClickListener) : RecyclerView.Adapter<GroceryListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grocery_list, null)
        view.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.click(items[position], listener)
        holder.bind(items[position])


    }


    override fun getItemCount(): Int {
        return items.size
    }


    interface OnItemClickListener {
        fun onClick(item: Item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item) = with(itemView) {
            val taskCb = findViewById<CheckBox>(R.id.checkBox)
            val name = findViewById<TextView>(R.id.name)
            name.text = item.name
            //  taskCb.isChecked = item.checked
        }

        fun click(item: Item, listener: GroceryListAdapter.OnItemClickListener) {
            itemView.setOnClickListener { listener.onClick(item) }
        }
    }
}