package com.ynavizovskyi.contacts.datastore.remote

import com.ynavizovskyi.contacts.data.ContactData
import com.ynavizovskyi.contacts.datastore.remote.response.GetContactsResponse

fun GetContactsResponse.toContactsData(): List<ContactData>{
    return results.map { ContactData(it.name.last) }
}