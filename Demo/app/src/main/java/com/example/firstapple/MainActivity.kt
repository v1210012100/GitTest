package com.example.firstapple

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
import io.reactivex.observers.DefaultObserver

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("mytest","  onCreate " )
        Log.e("mytest","  xia luo commit on MainActivity " )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Handler().post(Runnable {  })
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        lifecycle.addObserver(object:LifecycleEventObserver{
//            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
//                Log.e("mytest"," event   " +event)
//            }
//        })
        rxFun()

    }

    override fun onStart() {
//        Log.e("mytest","on onStart")
        super.onStart()
    }
    override fun onResume() {
//        Log.e("mytest","on Resume")
        super.onResume()
    }

    override fun onStop() {
//        Log.e("mytest","on onStop")
        super.onStop()
    }

    override fun onPause() {
//        Log.e("mytest","on onPause")
        super.onPause()
    }

    override fun onDestroy() {
//        Log.e("mytest","on onDestroy")
        super.onDestroy()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun rxFun(){
        Observable.create(object :ObservableOnSubscribe<String>{
            override fun subscribe(emitter: ObservableEmitter<String>) {
                Thread({
                    emitter.onNext("第一次")
                    emitter.onNext("第二次")
                    emitter.onNext("第三次")
                }).start()

            }
        }).subscribe({resp->
            Log.e("RxLog"," onNext "+resp)
        })
    }
}