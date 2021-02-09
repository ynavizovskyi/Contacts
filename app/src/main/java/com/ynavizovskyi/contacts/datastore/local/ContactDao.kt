package com.ynavizovskyi.contacts.datastore.local

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ContactDao : BaseRoomDao<ContactEntity>() {

    @Query(" SELECT * FROM ContactEntity")
    abstract suspend fun selectAll(): List<ContactEntity>

    @Query(" SELECT * FROM ContactEntity")
    abstract fun observeAll(): Flow<List<ContactEntity>>

    @Query(" SELECT * FROM ContactEntity WHERE id = :id")
    abstract fun observeById(id: Long): Flow<ContactEntity?>

    @Query("DELETE FROM ContactEntity")
    abstract fun deleteAll()

    @Query(" DELETE FROM ContactEntity WHERE id = :id")
    abstract fun deleteById(id: Long)

    @Query(" UPDATE ContactEntity SET firstName = :firstName AND lastName = :lastName AND email = :email WHERE id = :id")
    abstract fun update(id: Long, firstName: String, lastName: String, email: String)



}