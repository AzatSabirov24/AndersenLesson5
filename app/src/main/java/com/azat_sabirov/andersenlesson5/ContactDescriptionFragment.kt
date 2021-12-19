package com.azat_sabirov.andersenlesson5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class ContactDescriptionFragment : Fragment() {
    private var contact: Contact? = null
    private lateinit var tvName: TextView
    private lateinit var tvSurname: TextView
    private lateinit var tvPhoneNumber: TextView
    private lateinit var etName: EditText
    private lateinit var etSurname: EditText
    private lateinit var etPhoneNumber: EditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.let {
            contact = requireArguments().getSerializable(EXTRA_CONTACT) as Contact
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        etName.setText(contact?.name)
        etSurname.setText(contact?.surName)
        etPhoneNumber.setText(contact?.phoneNumber)
    }

    private fun initViews(view: View) {
        tvName = view.findViewById(R.id.tv_name)
        tvSurname = view.findViewById(R.id.tv_surname)
        tvPhoneNumber = view.findViewById(R.id.tv_phone_number)
        etName = view.findViewById(R.id.et_name)
        etSurname = view.findViewById(R.id.et_surname)
        etPhoneNumber = view.findViewById(R.id.et_phone_number)
    }

    companion object {
        const val TAG_CONTACT_DESCRIPTION_FRAGMENT = "TAG_CONTACT_DESCRIPTION_FRAGMENT"
        const val EXTRA_CONTACT = "EXTRA_CONTACT"

        fun newInstance(contact: Contact) = ContactDescriptionFragment().also {
            it.arguments = Bundle().apply {
                putSerializable(EXTRA_CONTACT, contact)
            }
        }
    }
}