package com.example.zinzineapp

import org.w3c.dom.Text
import java.util.Date

data class Emission (

        val id: Int,
        val titre: String,
        val datepub: String,
        val duree: Int,
        val url: String,
        val descriptif: String


)