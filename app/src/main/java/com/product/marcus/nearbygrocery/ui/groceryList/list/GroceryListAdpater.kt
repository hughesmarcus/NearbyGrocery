package com.product.marcus.nearbygrocery.ui.groceryList.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.product.marcus.nearbygrocery.R
import com.product.marcus.nearbygrocery.database.Item

class GroceryListAdapter(private val context: Context, private val items: List<Item>, private val listener: OnItemClickListener) : RecyclerView.Adapter<GroceryListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_to_do, null)
        view.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.click(items[holder.adapterPosition], listener)
        holder.bind(items[holder.adapterPosition], listener)



    }


    override fun getItemCount(): Int = items.size


    interface OnItemClickListener {
        fun onClick(item: Item)

        fun onCheckBoxClick(item: Item)
        
        
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item, listener: GroceryListAdapter.OnItemClickListener) = with(itemView) {
            val itemCb = findViewById<CheckBox>(R.id.checkBox)
            val name = findViewById<TextView>(R.id.name)
            name.text = item.name
            itemCb.isChecked = item.checked
            itemCb.setOnClickListener({
                listener.onCheckBoxClick(item)
            })
        }

        fun click(item: Item, listener: GroceryListAdapter.OnItemClickListener) {
            itemView.setOnClickListener { listener.onClick(item) }
        }
    }
}