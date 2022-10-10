package uz.crud.myretrofitwithmvvmapp.presentation

import android.app.Application
import android.util.Log

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e("TAG", "onCreate: I created")
    }
}