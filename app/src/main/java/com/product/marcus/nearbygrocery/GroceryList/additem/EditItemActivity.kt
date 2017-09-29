package com.product.marcus.nearbygrocery.GroceryList.additem

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.product.marcus.nearbygrocery.BaseActivity
import com.product.marcus.nearbygrocery.R
import com.product.marcus.nearbygrocery.database.Item

class EditItemActivity : BaseActivity() {
    lateinit var item: Item

    companion object {
        private val IT = "item"
        fun launch(context: Context) {
            val intent = Intent(context, EditItemActivity::class.java)
            // intent.putExtra(IT, item)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_item)
        val navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigation!!.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        //  item = intent.getParcelableExtra(ITEM)
    }
}
