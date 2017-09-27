package com.product.marcus.nearbygrocery.Pantry

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.product.marcus.nearbygrocery.BaseActivity
import com.product.marcus.nearbygrocery.R

class PantryListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantry_list)
        val navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigation!!.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
