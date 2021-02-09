package com.ynavizovskyi.contacts.datastore.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ContactEntity::class], version = 1)
abstract class RoomDatabaseManager : RoomDatabase(), DatabaseManager {

    companion object {
        fun create(context: Context): DatabaseManager {
            return Room
                .databaseBuilder(context, RoomDatabaseManager::class.java, "contacts")
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}