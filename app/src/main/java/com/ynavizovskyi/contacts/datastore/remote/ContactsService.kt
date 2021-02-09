package com.ynavizovskyi.contacts.datastore.remote

import com.ynavizovskyi.contacts.datastore.remote.response.GetContactsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ContactsService {

    @GET("")
    suspend fun getContacts(@Query("results") listSize: Int): GetContactsResponse

}