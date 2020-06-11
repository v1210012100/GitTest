package com.example.firstapple.RxDemo

interface ObservableOnSubscribe<T> {
    fun subscribe(emitter:Emitter<T>)
}