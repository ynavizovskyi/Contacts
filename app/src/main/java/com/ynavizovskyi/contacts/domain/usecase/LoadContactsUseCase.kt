package com.ynavizovskyi.contacts.domain.usecase

import com.ynavizovskyi.contacts.domain.dispatcher.DispatcherManager
import com.ynavizovskyi.contacts.domain.entity.Contact
import com.ynavizovskyi.contacts.domain.repository.ContactsRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoadContactsUseCase @Inject constructor(
    private val repository: ContactsRepository,
    private val dispatcherManager: DispatcherManager
) {

    suspend operator fun invoke(email: String, password: String): List<Contact> {
        return withContext(dispatcherManager.io){
            repository.load()
        }
    }

}