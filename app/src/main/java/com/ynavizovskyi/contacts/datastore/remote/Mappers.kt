package com.ynavizovskyi.contacts.datastore.remote

import com.ynavizovskyi.contacts.data.ContactData
import com.ynavizovskyi.contacts.datastore.remote.response.GetContactsResponse
import com.ynavizovskyi.contacts.datastore.remote.response.RemoteContact

fun GetContactsResponse.toContactsData(): List<ContactData>{
    return results.map { it.toData() }
}

fun RemoteContact.toData(): ContactData {
    val id = id.value.toLong()
    val firstName = name.first
    val lastName = name.last
    val pictureUrl = picture.medium
    val email = email

    return ContactData(id, firstName, lastName, email, pictureUrl)
}