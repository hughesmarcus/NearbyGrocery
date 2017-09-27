package com.product.marcus.nearbygrocery

import com.patloew.rxlocation.RxLocation
import com.product.marcus.nearbygrocery.models.PlaceResponse
import com.product.marcus.nearbygrocery.network.NetworkService
import com.product.marcus.nearbygrocery.network.PlacesApi
import com.product.marcus.nearbygrocery.stores.storelist.StoreListPresenterImpl
import com.product.marcus.nearbygrocery.stores.storelist.StoreListView
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable

import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.`when` as whenever
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.junit.*
import org.mockito.ArgumentMatchers

import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import org.testng.annotations.BeforeTest

@RunWith(MockitoJUnitRunner::class)
class GroceryPresenterTest {
    @Mock
    internal lateinit var view: StoreListView
    @Mock
    internal lateinit var service: NetworkService
    @Mock
    internal lateinit var location: RxLocation
    @Mock
    internal lateinit var permissions: RxPermissions
    @Mock
    internal lateinit var response: PlaceResponse
    @Mock
    internal lateinit var api: PlacesApi

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()


    //@get:Rule
    // var trampolineSchedulerRule = TrampolineSchedulerRule()
    internal lateinit var presenter: StoreListPresenterImpl

    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }

    @Before
    fun setup() {
        presenter = StoreListPresenterImpl(view, location, permissions, service)
    }

    @Test
    fun shouldLoadStores() {

        whenever(service.getAPI()).thenReturn(api)
        whenever(service.getAPI().getGroceryList(anyString(), anyInt(), anyString(), anyString())).thenReturn(Observable.just(response))
        presenter.getGroceryLocations(31.1, 31.1)
        verify(view, times(1)).getGroceryListSuccess(response)

    }

    @Test
    fun shouldLoadLocation() {
        presenter.getLocation()
        verify(presenter.getGroceryLocations(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyDouble()))
    }


}
