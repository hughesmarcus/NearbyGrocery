package com.product.marcus.nearbygrocery

import com.patloew.rxlocation.RxLocation
import com.product.marcus.nearbygrocery.models.PlaceResponse
import com.product.marcus.nearbygrocery.network.NetworkService
import com.product.marcus.nearbygrocery.stores.storelist.StoreListPresenterImpl
import com.product.marcus.nearbygrocery.stores.storelist.StoreListView
import com.tbruyelle.rxpermissions2.RxPermissions

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.junit.Rule

import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.verify

@RunWith(MockitoJUnitRunner::class)
class GroceryPresenterTest {
    @Mock
    internal var view: StoreListView? = null
    @Mock
    internal var service: NetworkService? = null
    @Mock
    internal var location: RxLocation? = null
    @Mock
    internal var permissions: RxPermissions? = null
    @Mock
    internal var response: PlaceResponse? = null
    @Mock
    internal var api: NetworkService.PlacesApi? = null
    @Mock
    internal var compositeDisposable: CompositeDisposable? = null

    @get:Rule
    var trampolineSchedulerRule = TrampolineSchedulerRule()
    private var presenter: StoreListPresenterImpl? = null
    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)


    }

    @Test
    fun shouldFetchJokesWhenRequested() {
        presenter = StoreListPresenterImpl(view!!, location!!, permissions!!, service!!, compositeDisposable!!)
        // when(api.getGroceryList(anyString(),anyInt(),anyString(),anyString())).thenReturn(Observable.just(response));
        presenter!!.getLocation()
        presenter!!.getGroceryLocations(31.1, 31.1)
        verify<NetworkService>(service).getAPI().getGroceryList(anyString(), anyInt(), anyString(), anyString())
    }

    companion object {
        @BeforeClass
        fun setUpClass() {
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        }
    }


}
