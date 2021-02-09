package com.ynavizovskyi.contacts.di

import android.content.Context
import com.ynavizovskyi.contacts.datastore.local.ContactDao
import com.ynavizovskyi.contacts.datastore.local.DatabaseManager
import com.ynavizovskyi.contacts.datastore.local.RoomDatabaseManager
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class LocalModule {

    @Provides
    @Singleton
    fun providesDatabaseManager(
        context: Context,
    ): DatabaseManager {
        return RoomDatabaseManager.create(context)
    }

    @Provides
    @Singleton
    fun providesContactDao(databaseManager: DatabaseManager): ContactDao {
        return databaseManager.contactDao()
    }

}