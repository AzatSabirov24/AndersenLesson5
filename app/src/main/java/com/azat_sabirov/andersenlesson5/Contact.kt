package com.azat_sabirov.andersenlesson5

import java.io.Serializable

data class Contact(var name: String, val surName: String, val phoneNumber: String) : Serializable
