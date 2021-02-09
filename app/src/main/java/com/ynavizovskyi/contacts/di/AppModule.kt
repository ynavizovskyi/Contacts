package com.ynavizovskyi.contacts.di

import android.app.Application
import android.content.Context
import com.ynavizovskyi.contacts.common.LOCAL
import com.ynavizovskyi.contacts.common.REMOTE
import com.ynavizovskyi.contacts.data.ContactsDataStore
import com.ynavizovskyi.contacts.data.ContactsRepositoryImpl
import com.ynavizovskyi.contacts.datastore.local.LocalContactsDataStore
import com.ynavizovskyi.contacts.datastore.remote.RemoteContactsDataStore
import com.ynavizovskyi.contacts.domain.dispatcher.DefaultDispatcherManager
import com.ynavizovskyi.contacts.domain.dispatcher.DispatcherManager
import com.ynavizovskyi.contacts.domain.repository.ContactsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module(includes = [NetworkModule::class, LocalModule::class])
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Binds
    abstract fun bindDispatcherManager(mana: DefaultDispatcherManager): DispatcherManager

    @Binds
    abstract fun bindRepository(repository: ContactsRepositoryImpl): ContactsRepository

    @Binds
    @Named(REMOTE)
    abstract fun bindRemoteContactsDataStore(dataStore: RemoteContactsDataStore): ContactsDataStore

    @Binds
    @Named(LOCAL)
    abstract fun bindLocalContactsDataStore(dataStore: LocalContactsDataStore): ContactsDataStore


}