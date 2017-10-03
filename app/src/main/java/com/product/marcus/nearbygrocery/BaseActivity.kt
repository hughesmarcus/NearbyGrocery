package com.product.marcus.nearbygrocery

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.product.marcus.nearbygrocery.GroceryList.list.GroceryListActivity
import com.product.marcus.nearbygrocery.Pantry.PantryListActivity
import com.product.marcus.nearbygrocery.stores.storelist.StoreListActivity
import kotlinx.android.synthetic.main.activity_store_list.*

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
