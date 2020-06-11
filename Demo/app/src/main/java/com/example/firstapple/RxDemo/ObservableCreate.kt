package com.example.firstapple.RxDemo

class ObservableCreate<T>( source:ObservableOnSubscribe<T>) :Observable<T>() {

    override fun subscribeActual(observer: Observer<T>) {

    }
//    class
}