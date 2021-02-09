package com.ynavizovskyi.contacts.datastore.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactEntity(
    val firstName: String,
    val lastName: String,
    val email: String,
    val pictureUrl: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)