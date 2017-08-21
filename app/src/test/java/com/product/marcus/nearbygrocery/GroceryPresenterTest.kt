package com.product.marcus.nearbygrocery

import android.app.Application

import com.patloew.rxlocation.RxLocation
import com.product.marcus.nearbygrocery.models.PlaceResponse
import com.product.marcus.nearbygrocery.models.Result
import com.product.marcus.nearbygrocery.network.NetworkService
import com.product.marcus.nearbygrocery.ui.GroceryListPresenterImpl
import com.product.marcus.nearbygrocery.ui.GroceryListView
import com.tbruyelle.rxpermissions2.RxPermissions

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.concurrent.Callable

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import retrofit2.Retrofit

import org.mockito.ArgumentMatchers.anyDouble
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

@RunWith(MockitoJUnitRunner::class)
class GroceryPresenterTest {
    @Mock
    internal var view: GroceryListView? = null
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
    private var presenter: GroceryListPresenterImpl? = null
    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)


    }

    @Test
    fun shouldFetchJokesWhenRequested() {
        presenter = GroceryListPresenterImpl(view!!, location!!, permissions!!, service!!, compositeDisposable!!)
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
