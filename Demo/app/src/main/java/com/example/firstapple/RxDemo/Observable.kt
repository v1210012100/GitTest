package com.example.firstapple.RxDemo

/***
 * Observable 对象的创建方式，都是通过工厂方法。
 * 一、通过传递一个 ObservableOnSubscribe 对象
 */
abstract class Observable<T> :ObservableSource<T> {
    override fun subscribe(observer: Observer<T>) {
        subscribeActual(observer)
    }
    abstract fun subscribeActual(observer: Observer<T>)
}