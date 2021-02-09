package com.ynavizovskyi.contacts.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.ynavizovskyi.contacts.R
import com.ynavizovskyi.contacts.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_contact_details.*
import kotlinx.android.synthetic.main.item_contact.view.*
import javax.inject.Inject

class ContactDetailsFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: ContactsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =  inflater.inflate(R.layout.fragment_contact_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.findViewById<Button>(R.id.button_second).setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }

        arguments?.getLong("contactId")?.apply{
            observeData(this)
        }

    }

    private fun observeData(contactId: Long){
        viewModel.observerContactById(contactId)
        viewModel.contactLiveData.observe(viewLifecycleOwner){
            textFirstName.text = it.firstName
            textLastName.text = it.lastName
            textEmail.text = it.email
            textUserPic.text = it.pictureUrl
        }
    }
}