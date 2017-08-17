package com.product.marcus.nearbygrocery;

import android.app.Application;

import com.patloew.rxlocation.RxLocation;
import com.product.marcus.nearbygrocery.models.PlaceResponse;
import com.product.marcus.nearbygrocery.models.Result;
import com.product.marcus.nearbygrocery.network.NetworkService;
import com.product.marcus.nearbygrocery.ui.GroceryListPresenterImpl;
import com.product.marcus.nearbygrocery.ui.GroceryListView;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GroceryPresenterTest {
    @Mock
    GroceryListView view;
    @Mock
    NetworkService service;
    @Mock
    RxLocation location;
    @Mock
    RxPermissions permissions;
    @Mock
    PlaceResponse response;
    @Mock
    NetworkService.PlacesApi api;


    private GroceryListPresenterImpl presenter;

    @Before
    public void setup() {

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        MockitoAnnotations.initMocks(this);
        presenter = new GroceryListPresenterImpl(view, location, permissions, service, compositeDisposable);

    }

    @Test
    public void shouldFetchJokesWhenRequested() {
        // when(api.getGroceryList(anyString(),anyInt(),anyString(),anyString())).thenReturn(Observable.just(response));
        presenter.getGroceryLocations(31.1, 31.1);
        verify(service).getAPI().getGroceryList(anyString(), anyInt(), anyString(), anyString());
    }


}
