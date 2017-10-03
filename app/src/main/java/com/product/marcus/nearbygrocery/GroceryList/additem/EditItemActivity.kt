package com.product.marcus.nearbygrocery.GroceryList.additem

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.View
import android.widget.EditText
import com.product.marcus.nearbygrocery.BaseActivity
import com.product.marcus.nearbygrocery.R
import com.product.marcus.nearbygrocery.database.Item
import android.widget.TextView


class EditItemActivity : BaseActivity() {
    lateinit var item: Item
    var minteger = 0
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
        intNav()
        //  item = intent.getParcelableExtra(ITEM)
    }

    fun increaseInteger(view: View) {
        minteger = minteger + 1
        display(minteger)

    }

    fun decreaseInteger(view: View) {
        minteger = minteger - 1
        display(minteger)
    }

    private fun display(number: Int) {
        val displayInteger = findViewById<EditText>(
                R.id.amount)
        //displayInteger.text = "" + number
    }
}
