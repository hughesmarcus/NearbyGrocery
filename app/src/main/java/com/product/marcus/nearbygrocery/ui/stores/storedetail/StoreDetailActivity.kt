package com.product.marcus.nearbygrocery.ui.stores.storedetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.product.marcus.nearbygrocery.ui.BaseActivity

import com.product.marcus.nearbygrocery.R
import com.product.marcus.nearbygrocery.models.Result
import kotlinx.android.synthetic.main.activity_store_detail.*

class StoreDetailActivity : BaseActivity(), StoreDetailView {
    lateinit var result: Result
    private lateinit var list: RecyclerView
    companion object {

        private val STORE = "store"


        fun launch(context: Context, result: Result) {
            val intent = Intent(context, StoreDetailActivity::class.java)
            intent.putExtra(STORE, result)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)
        list = findViewById<RecyclerView>(R.id.photo_list) as RecyclerView
        intNav()
        result = intent.getParcelableExtra(STORE)
        textView.text = result.name
        if (result.rating != null) {
            ratingBar.rating = result.rating!!.toFloat()
        } else {
            ratingBar.rating = 0F
        }
        init()
        // var link = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference="+ result.photos!![0].photoReference+"&key=AIzaSyA2BaZ3ue7tBn0naz2SyMI_vrXvorFKtgw"
        // Picasso.with(this).load(link).into(imageView)

    }

    fun init() {
        val adapter = PhotoAdapter(applicationContext, result)

        list!!.adapter = adapter
        list!!.layoutManager = LinearLayoutManager(this)
    }

    override fun onFailure(appErrorMessage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

