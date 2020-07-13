package com.example.firstapple

import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe

class RxDemo2 {
    var num = 666
    fun rxFun(){
        Observable.create(object : ObservableOnSubscribe<String> {
            override fun subscribe(emitter: ObservableEmitter<String>) {
                Thread({
                    ->
                    num = 7
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