package com.product.marcus.nearbygrocery.storedetail

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.product.marcus.nearbygrocery.R
import com.product.marcus.nearbygrocery.models.Result
import kotlinx.android.synthetic.main.activity_store_detail.*

class StoreDetailActivity : AppCompatActivity() {
    lateinit var result: Result

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
        result = intent.getParcelableExtra(STORE)
        textView.text = result.name
        if (result.rating != null) {
            ratingBar.rating = result.rating!!.toFloat()
        } else {
            ratingBar.rating = 0F
        }
    }
}

