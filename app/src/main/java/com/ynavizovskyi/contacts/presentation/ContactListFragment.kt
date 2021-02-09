package com.ynavizovskyi.contacts.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ynavizovskyi.contacts.R
import com.ynavizovskyi.contacts.presentation.base.BaseFragment
import javax.inject.Inject

class ContactListFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: ContactsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_contact_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData(){
        viewModel.contactsLiveData.observe(viewLifecycleOwner){
            it.forEach {
                Log.v("kjjj", it.lastName)
            }
        }
    }


}