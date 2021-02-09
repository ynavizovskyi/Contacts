package com.ynavizovskyi.contacts.di

import com.ynavizovskyi.contacts.presentation.ContainerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [FragmentBuilderModule::class])
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainFragment(): ContainerActivity?


}