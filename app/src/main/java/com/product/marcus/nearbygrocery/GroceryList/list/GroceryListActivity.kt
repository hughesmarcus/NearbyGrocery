package com.product.marcus.nearbygrocery.GroceryList.list

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.product.marcus.nearbygrocery.BaseActivity
import com.product.marcus.nearbygrocery.GroceryList.additem.EditItemActivity
import com.product.marcus.nearbygrocery.GroceryList.di.DaggerGroceryListComponent
import com.product.marcus.nearbygrocery.GroceryList.di.GroceryListContextModule
import com.product.marcus.nearbygrocery.R
import com.product.marcus.nearbygrocery.application.AppController
import com.product.marcus.nearbygrocery.database.Item
import javax.inject.Inject
import android.widget.Toast


class GroceryListActivity : BaseActivity(), GroceryListView {
    @Inject lateinit var presenter: GroceryListPresenter
    private var recyclerView: RecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grocery_list)
        val navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigation!!.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        DaggerGroceryListComponent.builder().
                appComponent(AppController.appComponent).
                groceryListContextModule(GroceryListContextModule(this)).
                build().inject(this)

        recyclerView = findViewById<RecyclerView>(R.id.items_rv) as RecyclerView
        init()

        presenter.onCreate(this)
    }

    private fun init() {
        val adapter = GroceryListAdapter(applicationContext, emptyList(),
                object : GroceryListAdapter.OnItemClickListener {
                    override fun onClick(item: Item) {
                        launchDetail()
                    }

                    override fun onCheckBoxClick(item: Item) {

                        item.checked = !item.checked
                        presenter.updateItem(item)
                    }

                })

        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.grocery_list_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.action_add -> Toast.makeText(this, "Add Item selected", Toast.LENGTH_SHORT)
                    .show()
            else -> {
            }
        }

        return true
    }
    fun launchDetail() {
        EditItemActivity.launch(this)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showItems(items: List<Item>) {
        recyclerView?.adapter = GroceryListAdapter(applicationContext, items,
                object : GroceryListAdapter.OnItemClickListener {
                    override fun onClick(item: Item) {
                        launchDetail()
                    }

                    override fun onCheckBoxClick(item: Item) {
                        item.checked = !item.checked

                        presenter.updateItem(item)

                    }
                })
    }

    override fun itemAddedAt(position: Int) {
        recyclerView?.adapter?.notifyItemInserted(position)
    }

    override fun scrollTo(position: Int) {
        recyclerView?.smoothScrollToPosition(position)
    }

    override fun itemUpdatedAt(position: Int) {
        recyclerView?.adapter?.notifyItemChanged(position)
        recyclerView?.adapter?.notifyDataSetChanged()
    }

}
