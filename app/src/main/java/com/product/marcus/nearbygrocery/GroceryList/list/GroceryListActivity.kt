package com.product.marcus.nearbygrocery.GroceryList.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import com.product.marcus.nearbygrocery.BaseActivity
import com.product.marcus.nearbygrocery.GroceryList.additem.EditItemActivity
import com.product.marcus.nearbygrocery.GroceryList.di.DaggerGroceryListComponent
import com.product.marcus.nearbygrocery.GroceryList.di.GroceryListContextModule
import com.product.marcus.nearbygrocery.R
import com.product.marcus.nearbygrocery.application.AppController
import com.product.marcus.nearbygrocery.database.Item
import com.product.marcus.nearbygrocery.models.Result
import com.product.marcus.nearbygrocery.stores.storelist.StoreListAdapter
import javax.inject.Inject

class GroceryListActivity : BaseActivity(), GroceryListView {
    @Inject lateinit var presenter: GroceryListPresenter

    var taskET: EditText? = null
    var addBtn: Button? = null
    var recyclerView: RecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grocery_list)
        val navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigation!!.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        DaggerGroceryListComponent.builder().
                appComponent(AppController.appComponent).
                groceryListContextModule(GroceryListContextModule(this)).
                build().inject(this)
        //   taskET = findViewById<EditText>(R.id.item_et) as EditText
        addBtn = findViewById<Button>(R.id.add_btn) as Button
        recyclerView = findViewById<RecyclerView>(R.id.items_rv) as RecyclerView
        init()


        addBtn?.setOnClickListener({ launchDetail() })

        presenter.onCreate(this)
    }

    fun init() {
        val adapter = GroceryListAdapter(applicationContext, emptyList(),
                object : GroceryListAdapter.OnItemClickListener {
                    override fun onClick(item: Item) {

                    }
                })
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(this)
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

                    }
                })
    }

    override fun itemAddedAt(position: Int) {
        recyclerView?.adapter?.notifyItemInserted(position)
    }

    override fun scrollTo(position: Int) {
        recyclerView?.smoothScrollToPosition(position)
    }
}
