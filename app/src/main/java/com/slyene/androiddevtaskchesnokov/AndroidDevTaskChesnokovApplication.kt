package com.slyene.androiddevtaskchesnokov

import android.app.Application
import com.slyene.androiddevtaskchesnokov.di.dataModules
import com.slyene.androiddevtaskchesnokov.di.domainModules
import com.slyene.androiddevtaskchesnokov.di.presentationModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AndroidDevTaskChesnokovApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AndroidDevTaskChesnokovApplication)
            modules(presentationModules + domainModules + dataModules)
        }
    }
}