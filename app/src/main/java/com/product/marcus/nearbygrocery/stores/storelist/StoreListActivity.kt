package com.product.marcus.nearbygrocery.stores.storelist

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

import com.patloew.rxlocation.RxLocation
import com.product.marcus.nearbygrocery.R
import com.product.marcus.nearbygrocery.models.PlaceResponse
import com.product.marcus.nearbygrocery.models.Result
import com.product.marcus.nearbygrocery.network.NetworkService
import com.product.marcus.nearbygrocery.stores.storedetail.StoreDetailActivity
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.CompositeDisposable
import android.support.v7.widget.DividerItemDecoration
import com.product.marcus.nearbygrocery.BaseActivity
import kotlinx.android.synthetic.main.grocery_list.*


class StoreListActivity : BaseActivity(), StoreListView {
    private lateinit var list: RecyclerView
    lateinit var rxPermission: RxPermissions
    lateinit var rxLocation: RxLocation
    lateinit var presenter: StoreListPresenterImpl
    lateinit var service: NetworkService
    internal lateinit var progressBar: ProgressBar
    lateinit var compositeDisposable: CompositeDisposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_list)
        val navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigation!!.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        compositeDisposable = CompositeDisposable()
        rxPermission = RxPermissions(this)
        rxLocation = RxLocation(this)
        service = NetworkService()
        presenter = StoreListPresenterImpl(this, rxLocation, rxPermission, service)
        presenter.getLocation()
        renderView()
        init()

    }

    fun renderView() {
        list = findViewById<RecyclerView>(R.id.activity_stations_recyclerView) as RecyclerView
        val layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(list.getContext(),
                layoutManager.getOrientation())
        list.addItemDecoration(dividerItemDecoration)
        progressBar = findViewById<ProgressBar>(R.id.activity_stations_progressBar) as ProgressBar
    }

    fun init() {
        val adapter = StoreListAdapter(applicationContext, ArrayList<Result>(),
                object : StoreListAdapter.OnItemClickListener {
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
            val adapter = StoreListAdapter(applicationContext, placeResponse.results!!,

                    object : StoreListAdapter.OnItemClickListener {
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
