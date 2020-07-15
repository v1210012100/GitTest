package com.example.firstapple

import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe

class RxDemo2 {
    var num = 666
    var str = " 吃放吃饭"
    var str2 = " 吃放吃饭3"
    var str3 = " 睡觉 "
    var str4 = " 不睡觉"
    var str33 = " 吃放吃饭"
    var str3333 = " 睡觉 "
    var str035 = " ZHENYAO睡觉 LE"
    var str036 = "  新的东西 "
    var str037 = " ------------- 你也在本地做了一些修改 "
    fun rxFun(){
        var str= " develope first commite "
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
        var str035 = " 22222---ZHENYAO睡觉 LE"
        var str036 = " 5555 新的东西 "
        var str037 = " ------------- 你也在本地做了一些修改 "

        var str100 = "  P1  我是base 分支  "
    }
}