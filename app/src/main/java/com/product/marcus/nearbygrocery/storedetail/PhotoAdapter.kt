package com.product.marcus.nearbygrocery.storedetail

import android.content.Context
import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.product.marcus.nearbygrocery.R
import com.product.marcus.nearbygrocery.models.Result
import com.product.marcus.nearbygrocery.ui.GroceryListAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_store_detail.*

/**
 * Created by Marcus on 8/21/2017.
 */
class PhotoAdapter(private val context: Context, private val data: Result) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_list, null)
        view.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: PhotoAdapter.ViewHolder, position: Int) {
        // holder.click(data[position], listener)
        var link = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=" + data.photos!![position].photoReference + "&key=AIzaSyA2BaZ3ue7tBn0naz2SyMI_vrXvorFKtgw"
        Picasso.with(context)
                .load(link)
                .config(Bitmap.Config.RGB_565)
                .into(holder.image)


    }

    override fun getItemCount(): Int {
        return data.photos!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var image: ImageView


        init {
            image = itemView.findViewById<ImageView>(R.id.photo)


        }


        fun click(result: Result, listener: GroceryListAdapter.OnItemClickListener) {
            itemView.setOnClickListener { listener.onClick(result) }
        }
    }
}