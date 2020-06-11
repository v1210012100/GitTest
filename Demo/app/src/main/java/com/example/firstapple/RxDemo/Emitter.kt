package com.example.firstapple.RxDemo

interface Emitter<T> {
    fun onNext(t:T)
    fun onError()
}