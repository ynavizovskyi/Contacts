package com.ynavizovskyi.contacts.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ynavizovskyi.contacts.domain.entity.Contact
import com.ynavizovskyi.contacts.domain.usecase.LoadContactsUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

class ContactsViewModel @Inject constructor(private val loadContactsUseCase: LoadContactsUseCase) : ViewModel() {

    init {
        loadContacts()
    }

    val contactsLiveData: MutableLiveData<List<Contact>> = MutableLiveData()

//    val handler = CoroutineExceptionHandler { _, exception ->
//        signInLiveData.value = false
//    }

    fun loadContacts(){
        viewModelScope.launch {
            val contacts = loadContactsUseCase.invoke()
            contactsLiveData.value = contacts
        }
    }

}