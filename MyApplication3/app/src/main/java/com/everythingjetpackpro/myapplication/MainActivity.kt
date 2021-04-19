package com.everythingjetpackpro.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val parties = Party.getParty()
        val partyAdapter = PartyAdapter(parties)

        findViewById<RecyclerView>(R.id.rvCandidates).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.rvCandidates).adapter = partyAdapter
    }
}