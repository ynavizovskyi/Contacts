package com.ynavizovskyi.contacts.presentation.contactlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ynavizovskyi.contacts.R
import com.ynavizovskyi.contacts.presentation.ContactsViewModel
import com.ynavizovskyi.contacts.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_contact_list.*
import javax.inject.Inject

class ContactListFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: ContactsViewModel

    private val contactsAdapter = ContactsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_contact_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        contactsRecyclerView.layoutManager = layoutManager
        contactsRecyclerView.adapter = contactsAdapter


        observeData()
    }

    private fun observeData(){
        viewModel.contactsLiveData.observe(viewLifecycleOwner){ contacts ->
            contactsAdapter.setData(contacts)
        }
    }


}