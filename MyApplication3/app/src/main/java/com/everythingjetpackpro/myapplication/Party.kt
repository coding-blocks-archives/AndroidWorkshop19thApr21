package com.everythingjetpackpro.myapplication

import java.util.*

data class Party(
    val partyName: String,
    val Candidate: String
) {

    companion object {


        private val Party_Names = arrayOf(
            "Bharatiya Janata Party",
            "Indian National Congress",
            "Bahujan Samaj Party",
            "Communist Party Of India"
        )

        private val Candidates_Names =
            arrayOf("Narendra Modi", "Rahul Gandhi", "Mayawati", "Ramachandran")

        fun getParty(): ArrayList<Party> {

            val partyArray = ArrayList<Party>(4)
            repeat(4) { i ->
                partyArray.add(Party(Party_Names[i], Candidates_Names[i]))
            }


            return partyArray

        }


    }


}