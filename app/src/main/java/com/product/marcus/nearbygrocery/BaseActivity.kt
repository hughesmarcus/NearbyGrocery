package com.product.marcus.nearbygrocery

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.product.marcus.nearbygrocery.stores.storelist.StoreListActivity
import kotlinx.android.synthetic.main.activity_store_list.*

open class BaseActivity : AppCompatActivity() {


    internal val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_store_list -> {
                Toast.makeText(applicationContext, "Stores",
                        Toast.LENGTH_LONG).show()
                val intent = Intent(this, StoreListActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_pantry -> {
                Toast.makeText(applicationContext, "Pantry",
                        Toast.LENGTH_LONG).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_grocery_list -> {
                Toast.makeText(applicationContext, "List",
                        Toast.LENGTH_LONG).show()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

}
