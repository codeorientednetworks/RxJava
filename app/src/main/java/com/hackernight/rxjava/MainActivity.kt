package com.hackernight.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    val TAG = "my_app"
    lateinit var observable : Observable<String>
    lateinit var disposableObserver: DisposableObserver<String>
    lateinit var disposableObserver2: DisposableObserver<String>
    lateinit var compositeDisposable = CompositeDisposable()

    //lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observable = Observable.just("Amit Kumar")
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())


        /*        observer = object : Observer<String>{
            override fun onSubscribe(d: Disposable) {
                disposable = d
            }

            override fun onNext(t: String) {
                Log.d(TAG,"On Next $t")
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {
                Log.d(TAG,"On Complete")            }

        }*/


        disposableObserver = object : DisposableObserver<String>() {
            override fun onNext(t: String) {
                Log.d(TAG,"On Next $t")
            }
            override fun onError(e: Throwable) {
                TODO("Not yet implemented")
            }
            override fun onComplete() {
                TODO("Not yet implemented")
            }
        }

        compositeDisposable.add(disposableObserver)
        observable.subscribe(disposableObserver)


        disposableObserver2 = object :DisposableObserver<String>(){
            override fun onNext(t: String) {
                Log.d(TAG,"On Next $t")
            }
            override fun onError(e: Throwable) {
                TODO("Not yet implemented")
            }
            override fun onComplete() {
                TODO("Not yet implemented")
            }
        }

        compositeDisposable.add(disposableObserver2)
        observable.subscribe(disposableObserver2)

    }

    override fun onDestroy() {
        compositeDisposable.clear()
        /*disposableObserver.dispose()
        disposableObserver2.dispose()*/
        super.onDestroy()
    }

}