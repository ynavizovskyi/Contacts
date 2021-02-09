package com.ynavizovskyi.contacts.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ynavizovskyi.contacts.R
import com.ynavizovskyi.contacts.domain.entity.Contact
import com.ynavizovskyi.contacts.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_edit_contact.*
import javax.inject.Inject

class EditContactFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: ContactsViewModel

    private var contact: Contact? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =  inflater.inflate(R.layout.fragment_edit_contact, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contactId = arguments?.getLong("contactId")

        contactId?.apply{
            observeData(this)
        }

        buttonSave.setOnClickListener {
            contact?.let {
                val editedContact = it.copy(firstName = it.firstName + " EDITED", lastName = it.lastName + " EDITED", email = it.email + " EDITED")

                viewModel.updateContact(editedContact)
            }
        }

    }

    private fun observeData(contactId: Long){
        viewModel.observerContactById(contactId)
        viewModel.contactLiveData.observe(viewLifecycleOwner){
            it?.let {
                contact = it
                textFirstName.text = it.firstName
                textLastName.text = it.lastName
                textEmail.text = it.email
                textUserPic.text = it.pictureUrl
            }

        }
    }
}