package com.hackernight.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    val TAG = "my_app"
    lateinit var observable : Observable<String>
    lateinit var observer: Observer<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observable = Observable.just("Amit Kumar")
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

        observer = object : Observer<String>{
            override fun onSubscribe(d: Disposable) {
                TODO("Not yet implemented")
            }

            override fun onNext(t: String) {
                Log.d(TAG,"On Next $t")
            }

            override fun onError(e: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onComplete() {
                Log.d(TAG,"On Complete")            }

        }

        observable.subscribe(observer)

    }

}