package com.azat_sabirov.andersenlesson5

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class ContactNameFragment : Fragment() {
    private var controller: Controller? = null
    private lateinit var linearLayout: LinearLayout
    private val contact1 = Contact("Stepan", "Vasiliev", "8935556673")
    private val contact2 = Contact("Denis", "Petrov", "89534846673")
    private val contact3 = Contact("Andrey", "Ivanov", "86545666673")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        controller = context as Controller
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayout = view.findViewById(R.id.contacts_linear_layout)
        addViews(view)
    }

    private fun addViews(view: View) {
        addContactToList(contact1)
        addContactToList(contact2)
        addContactToList(contact3)
    }

    private fun addContactToList(contact: Contact) {
        val tvContact = TextView(context).apply {
            text = contact.name
            textSize = 30F
            setOnClickListener {
                (activity as Controller).openContactScreen(contact)
            }
        }
        linearLayout.addView(tvContact)
    }

    override fun onDetach() {
        super.onDetach()
        controller = null
    }

    interface Controller {
        fun openContactScreen(contact: Contact)
    }

    companion object {
        const val TAG_CONTACT_NAME_FRAGMENT = "TAG_CONTACT_NAME_FRAGMENT"
        const val EXTRA_CONTACT = "EXTRA_CONTACT"

        fun newInstance(contact: Contact?) = ContactNameFragment().also {
            it.arguments = Bundle().apply {
                putSerializable(EXTRA_CONTACT, contact)
            }
        }
    }
}
