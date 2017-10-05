package com.product.marcus.nearbygrocery.ui.stores.storelist

import android.Manifest
import android.util.Log

import com.patloew.rxlocation.RxLocation
import com.tbruyelle.rxpermissions2.RxPermissions
import com.google.android.gms.location.LocationRequest
import com.product.marcus.nearbygrocery.network.NetworkService
import io.reactivex.disposables.CompositeDisposable

import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers


class StoreListPresenterImpl(private var view: StoreListView?, private var rxLocation: RxLocation,
                             private var permission: RxPermissions, private var service: NetworkService) : StoreListPresenter {
    private var compositeDisposable: CompositeDisposable? = null

    init {
        this.compositeDisposable = CompositeDisposable()
    }

    override fun getLocation() {
        permission
                .request(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe({ granted ->
                    if (granted) {
                        val locationRequest = LocationRequest.create()
                                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                                .setExpirationDuration(15)

                        rxLocation.location().updates(locationRequest)
                                .flatMap({ location -> rxLocation.geocoding().fromLocation(location).toObservable() })
                                .subscribe({ address ->
                                    Log.i("Main", address.latitude.toString())

                                    getGroceryLocations(address.latitude, address.longitude)
                                })
                    } else {
                        Log.i("Main", "denied")
                    }
                })
    }

    override fun getGroceryLocations(lat: Double, lon: Double) {

        val location = lat.toString() + "," + lon.toString()
        compositeDisposable?.add(service.getAPI().getGroceryList(location, 5000, "store", "AIzaSyBkTm63dmUG6QeLxt3owh-AMuoIP9SPg8A")
                .subscribeOn(Schedulers.io())
                .doOnError { error -> view?.onFailure(error.localizedMessage) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ PlaceResponse -> view?.getGroceryListSuccess(PlaceResponse) }))

    }

    override fun onDestroy() {
        compositeDisposable?.dispose()
        view = null
    }
}