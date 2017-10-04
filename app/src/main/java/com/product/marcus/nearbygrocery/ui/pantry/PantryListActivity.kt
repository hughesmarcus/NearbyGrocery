package com.product.marcus.nearbygrocery.ui.pantry

import android.os.Bundle
import com.product.marcus.nearbygrocery.ui.BaseActivity
import com.product.marcus.nearbygrocery.R

class PantryListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantry_list)
        intNav()
    }
}
