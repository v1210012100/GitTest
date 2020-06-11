package com.example.firstapple.RxDemo

interface Observer<T> {
    fun onSubscribe()
    fun onNext(t:T)
    fun onError()
    fun onComplete()
}