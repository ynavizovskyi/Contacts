package com.ynavizovskyi.contacts.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ynavizovskyi.contacts.domain.entity.Contact
import com.ynavizovskyi.contacts.domain.usecase.ObserveContactsUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ContactsViewModel @Inject constructor(private val loadContactsUseCase: ObserveContactsUseCase) : ViewModel() {

    init {
        loadContacts()
    }

    val contactsLiveData: MutableLiveData<List<Contact>> = MutableLiveData()

    fun loadContacts(){
        viewModelScope.launch {
            loadContactsUseCase.invoke()
                .collect {
                    contactsLiveData.value = it
                }
        }
    }

}