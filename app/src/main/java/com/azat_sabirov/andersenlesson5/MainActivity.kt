package com.azat_sabirov.andersenlesson5

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ContactNameFragment.Controller {
    private val contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragment(contact)
    }

    private fun setFragment(contact: Contact?) {
        supportFragmentManager.beginTransaction().run {
            val fragment = ContactNameFragment.newInstance(contact)
            replace(
                R.id.fragment_names_container,
                fragment,
                ContactNameFragment.TAG_CONTACT_NAME_FRAGMENT
            )
            addToBackStack(ContactNameFragment.TAG_CONTACT_NAME_FRAGMENT)
            commit()
        }
    }

    override fun openContactScreen(contact: Contact) {
        supportFragmentManager.beginTransaction().run {
            val fragment = ContactDescriptionFragment.newInstance(contact)
            replace(
                R.id.fragment_names_container,
                fragment,
                ContactDescriptionFragment.TAG_CONTACT_DESCRIPTION_FRAGMENT
            )
            addToBackStack(null)
            commit()
        }
    }
}