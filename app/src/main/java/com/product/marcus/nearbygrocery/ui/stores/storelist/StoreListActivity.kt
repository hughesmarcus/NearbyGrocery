package com.product.marcus.nearbygrocery.ui.stores.storelist

import android.os.Bundle
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
import com.product.marcus.nearbygrocery.ui.stores.storedetail.StoreDetailActivity
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.CompositeDisposable
import android.support.v7.widget.DividerItemDecoration
import com.product.marcus.nearbygrocery.ui.BaseActivity
import javax.inject.Inject


class StoreListActivity : BaseActivity(), StoreListView {
    private lateinit var list: RecyclerView
    private lateinit var rxPermission: RxPermissions
    private lateinit var rxLocation: RxLocation
    private lateinit var presenter: StoreListPresenterImpl
    private lateinit var service: NetworkService
    private lateinit var progressBar: ProgressBar
    private lateinit var compositeDisposable: CompositeDisposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_list)
        intNav()
        compositeDisposable = CompositeDisposable()
        rxPermission = RxPermissions(this)
        rxLocation = RxLocation(this)
        service = NetworkService()
        presenter = StoreListPresenterImpl(this, rxLocation, rxPermission, service)
        presenter.getLocation()
        renderView()
        init()

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    private fun renderView() {
        list = findViewById<RecyclerView>(R.id.activity_stations_recyclerView) as RecyclerView
        val layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(list.context,
                layoutManager.orientation)
        list.addItemDecoration(dividerItemDecoration)
        progressBar = findViewById<ProgressBar>(R.id.activity_stations_progressBar) as ProgressBar
    }

    private fun init() {
        val adapter = StoreListAdapter(applicationContext, ArrayList(),
                object : StoreListAdapter.OnItemClickListener {
                    override fun onClick(Item: Result) {

                    }
                })
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)
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
        if ((!(placeResponse.results != null && !placeResponse.results!!.isEmpty())).not()) {
            val adapter = StoreListAdapter(applicationContext, placeResponse.results!!,

                    object : StoreListAdapter.OnItemClickListener {
                        override fun onClick(Item: Result) {

                            launchDetail(Item)
                            Toast.makeText(applicationContext, Item.name,
                                    Toast.LENGTH_LONG).show()
                        }
                    })

            list.adapter = adapter
            adapter.notifyDataSetChanged()
        } else {
            Toast.makeText(applicationContext, "NOOOOOOOO",
                    Toast.LENGTH_LONG).show()
        }
    }

}
