package com.ynavizovskyi.contacts.datastore.local

interface DatabaseManager {

    fun contactDao(): ContactDao

}