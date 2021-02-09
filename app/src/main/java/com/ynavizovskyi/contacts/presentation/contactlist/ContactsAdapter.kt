package com.ynavizovskyi.contacts.presentation.contactlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ynavizovskyi.contacts.R
import com.ynavizovskyi.contacts.domain.entity.Contact
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactsAdapter(
    private val itemClickListener: (Contact) -> Unit,
    private val deleteContactListener: (Contact) -> Unit
) :
    RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    private var data: List<Contact> = emptyList()

    fun setData(contacts: List<Contact>) {
        data = contacts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view, itemClickListener, deleteContactListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = data[position]
        holder.bind(contact)
    }

    override fun getItemCount() = data.size

    class ViewHolder(
        itemView: View, private val itemClickListener: (Contact) -> Unit,
        private val deleteContactListener: (Contact) -> Unit
    ) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(item: Contact) {
            itemView.textFirstName.text = item.firstName
            itemView.textLastName.text = item.lastName
            itemView.textEmail.text = item.email
            itemView.textUserPic.text = item.pictureUrl
            itemView.setOnClickListener { itemClickListener.invoke(item) }
            itemView.buttonDelete.setOnClickListener {
                deleteContactListener.invoke(item)
            }
        }

    }

}