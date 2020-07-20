package com.example.firstapple

import android.accounts.NetworkErrorException
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DefaultObserver
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            concatTest()
        }

    }

    val cacheObservable = Observable.fromCallable {
        Thread.sleep(500)
        Log.e("mytest", " 缓存加载数据成功 " )
        " 从缓存中加载数据"
    }.subscribeOn(Schedulers.io())

    val netObservable = Observable.fromCallable {
        throw (NetworkErrorException())
        Thread.sleep(2000)
        Log.e("mytest", " 网络拉取数据成功 " )
        " 从网络中加载数据"
    }.subscribeOn(Schedulers.computation())





    fun getCacheOb():Observable<String>{
        return Observable.create(object : ObservableOnSubscribe<String> {
            override fun subscribe(it: ObservableEmitter<String>) {
//            Thread.sleep(500)
                it.onNext(" 从缓存中加载数据")
                it.onComplete()
            }
        }).subscribeOn(Schedulers.io())
    }

    fun getNetOb():Observable<String>{
        return Observable.create(object : ObservableOnSubscribe<String> {
            override fun subscribe(it: ObservableEmitter<String>) {
                throw(Error())
//            Thread.sleep(2000)
//            it.onNext(" 从网络中加载数据")
//            it.onComplete()
            }
        }).subscribeOn(Schedulers.io())
    }

    @SuppressLint("CheckResult")
    fun concatTest() {
        Schedulers.io().createWorker()
        // Note that onError notifications will cut ahead of onNext notifications on the emission
        val list = listOf(cacheObservable,netObservable)
        Observable.concat(getCacheOb(),getNetOb()).observeOn(AndroidSchedulers.mainThread())
//        Observable.concatEager(list2).observeOn(AndroidSchedulers.mainThread())
//        Observable.concatEager(list2).observeOn(Schedulers.io())
            .subscribe(object :Observer<String>{
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: String) {
                    Log.e("mytest","  onNext  "+t)
                }

                override fun onError(e: Throwable) {
                    Log.e("mytest","  onError  "+e)
                }

            })
    }

}