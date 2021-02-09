package com.ynavizovskyi.contacts.datastore.remote.response

data class RemoteContact(val id: RemoteId, val name: RemoteName, val picture: RemotePicture, val email: String)