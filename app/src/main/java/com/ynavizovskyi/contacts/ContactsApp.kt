package com.ynavizovskyi.contacts

import android.app.Activity
import android.app.Application
import com.ynavizovskyi.contacts.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class ContactsApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        initDependencyInjection()
    }

    private fun initDependencyInjection(){
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }

}