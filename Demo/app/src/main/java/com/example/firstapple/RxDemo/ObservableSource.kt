package com.example.firstapple.RxDemo

interface ObservableSource<T> {
    fun subscribe(observer:Observer<T>)
}