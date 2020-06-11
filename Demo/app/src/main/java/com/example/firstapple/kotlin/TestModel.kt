package com.example.firstapple.kotlin

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class Outter{
    companion object {
        val num = 5
        val  strList = listOf<String>()

        val map = HashMap<String,Int>()
        @JvmStatic
        fun getStaticStr():String{
            return " compation str"
        }
    }
    var  liveData  = MutableLiveData<ArrayList<String>>()
    fun bind(activity: AppCompatActivity){
        liveData.observe(activity, Observer {

        })
    }
    //  ?.
    fun update(str:String?):String?{
        str?.substring(3)
        return str?.let {
            it.plus("nnen")
            it.plus("hahah") }
    }

    fun update2(str:String):String{
        // 不为空 则 返回 str
        return  str?:"null"
    }
    fun main(){
        update(" ")
    }

}