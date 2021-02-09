package com.ynavizovskyi.contacts.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ynavizovskyi.contacts.domain.entity.Contact
import com.ynavizovskyi.contacts.domain.usecase.ObserveContactsUseCase
import com.ynavizovskyi.contacts.domain.usecase.ObserveContactUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ContactsViewModel @Inject constructor(
    private val observeContactsUseCase: ObserveContactsUseCase,
    private val observeContactUseCase: ObserveContactUseCase
) :
    ViewModel() {

//    init {
//        observerContacts()
//    }

    val contactsLiveData: MutableLiveData<List<Contact>> = MutableLiveData()
    val contactLiveData: MutableLiveData<Contact> = MutableLiveData()

    fun observerContacts() {
        viewModelScope.launch {
            observeContactsUseCase.invoke()
                .collect {
                    contactsLiveData.value = it
                }
        }
    }

    fun observerContactById(id: Long) {
        viewModelScope.launch {
            observeContactUseCase.invoke(id)
                .collect {
                    contactLiveData.value = it
                }
        }
    }

}