package com.product.marcus.nearbygrocery.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.product.marcus.nearbygrocery.R
import com.product.marcus.nearbygrocery.ui.groceryList.list.GroceryListActivity
import com.product.marcus.nearbygrocery.ui.pantry.PantryListActivity
import com.product.marcus.nearbygrocery.ui.stores.storelist.StoreListActivity

open class BaseActivity : AppCompatActivity() {


    internal val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_store_list -> {

                val intent = Intent(this, StoreListActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_pantry -> {
                val intent = Intent(this, PantryListActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_grocery_list -> {
                val intent = Intent(this, GroceryListActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    fun intNav() {
        val navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigation!!.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }


}
