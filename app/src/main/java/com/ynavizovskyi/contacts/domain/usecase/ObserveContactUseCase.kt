package com.ynavizovskyi.contacts.domain.usecase

import com.ynavizovskyi.contacts.domain.dispatcher.DispatcherManager
import com.ynavizovskyi.contacts.domain.entity.Contact
import com.ynavizovskyi.contacts.domain.repository.ContactsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ObserveContactUseCase @Inject constructor(
    private val repository: ContactsRepository,
    private val dispatcherManager: DispatcherManager
) {

    suspend operator fun invoke(id: Long): Flow<Contact> {
        return withContext(dispatcherManager.io){
            repository.observeContactById(id)
        }
    }

}