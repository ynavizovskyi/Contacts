package com.ynavizovskyi.contacts.datastore.local

import androidx.room.Query
import kotlinx.coroutines.flow.Flow

abstract class ContactDao : BaseRoomDao<ContactEntity>() {

    @Query(" SELECT * FROM ContactEntity")
    abstract suspend fun selectAll(): List<ContactEntity>

    @Query(" SELECT * FROM ContactEntity")
    abstract suspend fun observeAll(): Flow<List<ContactEntity>>

}