package com.product.marcus.nearbygrocery.ui

import android.Manifest
import android.util.Log

import com.google.android.gms.common.api.GoogleApiClient
import com.patloew.rxlocation.RxLocation
import com.tbruyelle.rxpermissions2.RxPermissions
import com.google.android.gms.location.LocationRequest
import com.product.marcus.nearbygrocery.network.NetworkService
import com.product.marcus.nearbygrocery.ui.GroceryListPresenter
import io.reactivex.disposables.CompositeDisposable

import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers



/**
 * Created by Marcus on 8/15/2017.
 */
class GroceryListPresenterImpl(private val view: GroceryListView,var rxLocation: RxLocation, var permission: RxPermissions, var service:NetworkService): GroceryListPresenter {


    protected var compositeDisposable: CompositeDisposable? = null

    init {
        this.compositeDisposable = CompositeDisposable()
    }

    override fun getLocation(){
        permission
                .request(Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe({ granted-> if (granted)
                {
                    val locationRequest = LocationRequest.create()
                            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                            .setInterval(500000)

                    rxLocation.location().updates(locationRequest)
                            .flatMap({ location -> rxLocation.geocoding().fromLocation(location).toObservable() })
                            .subscribe({ address ->
                                Log.i("Main", address.latitude.toString())
                                getGroceryLocations(address.latitude , address.longitude)
                            })
                }
                else
                {
                   Log.i("Main", "denied")
                } })
    }
   override fun getGroceryLocations( lat:Double, lon:Double ){
       var location = lat.toString() +","+ lon.toString()
       compositeDisposable!!.add(service.getAPI().getGroceryList(location,5000,"store","AIzaSyA2BaZ3ue7tBn0naz2SyMI_vrXvorFKtgw")
               .subscribeOn(Schedulers.computation())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe({ PlaceResponse -> view.getGroceryListSuccess(PlaceResponse) }))

   }

    override fun rxUnSubscribe() {
        compositeDisposable!!.clear()
    }

}