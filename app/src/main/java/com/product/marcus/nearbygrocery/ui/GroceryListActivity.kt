package com.product.marcus.nearbygrocery.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

import com.patloew.rxlocation.RxLocation
import com.product.marcus.nearbygrocery.R
import com.product.marcus.nearbygrocery.models.PlaceResponse
import com.product.marcus.nearbygrocery.models.Result
import com.product.marcus.nearbygrocery.network.NetworkService
import com.product.marcus.nearbygrocery.storedetail.StoreDetailActivity
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.CompositeDisposable

class GroceryListActivity : AppCompatActivity(),GroceryListView {
    private lateinit var list: RecyclerView
    lateinit var rxPermission: RxPermissions
    lateinit var rxLocation: RxLocation
    lateinit var presenter: GroceryListPresenterImpl
    lateinit var service:NetworkService
    internal lateinit var progressBar: ProgressBar
    lateinit var compositeDisposable: CompositeDisposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        compositeDisposable = CompositeDisposable()
        rxPermission = RxPermissions(this)
        rxLocation = RxLocation(this)
        service = NetworkService()
        presenter = GroceryListPresenterImpl(this, rxLocation, rxPermission, service, compositeDisposable)
        presenter.getLocation()
        renderView()
        init()

    }
    fun renderView() {
        list = findViewById(R.id.activity_stations_recyclerView) as RecyclerView
        progressBar = findViewById(R.id.activity_stations_progressBar) as ProgressBar
    }

    fun init() {
        val adapter = GroceryListAdapter(applicationContext, ArrayList<Result>(),
                object : GroceryListAdapter.OnItemClickListener {
                    override fun onClick(Item: Result) {

                    }
                })
        list!!.adapter = adapter
        list!!.layoutManager = LinearLayoutManager(this)
    }

    fun launchDetail(result: Result) {
        StoreDetailActivity.launch(this, result)
    }

    override fun showWait() {
        progressBar.visibility = View.VISIBLE
    }

    override fun removeWait() {
        progressBar.visibility = View.GONE
    }

    override fun onFailure(appErrorMessage: String) {

    }
   override fun getGroceryListSuccess(placeResponse: PlaceResponse) {
        removeWait()
       if (placeResponse != null && placeResponse.results != null && placeResponse.results!!.size > 0) {
           Log.d("Hello", Integer.toString(placeResponse.results!!.size))
           val adapter = GroceryListAdapter(applicationContext, placeResponse.results!!,

                    object : GroceryListAdapter.OnItemClickListener {
                        override fun onClick(Item: Result) {

                            launchDetail(Item)
                            Toast.makeText(applicationContext, Item.name,
                                    Toast.LENGTH_LONG).show()
                        }
                    })

            list!!.adapter = adapter
            adapter.notifyDataSetChanged()
        } else {
            Toast.makeText(applicationContext, "NOOOOOOOO",
                    Toast.LENGTH_LONG).show()
        }
    }

}
