package com.everythingjetpackpro.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class PartyAdapter(private val Parties: ArrayList<Party>) :
    RecyclerView.Adapter<PartyAdapter.PartyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_party, parent, false
        )
        return PartyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PartyViewHolder, position: Int) {

        holder.itemView.findViewById<TextView>(R.id.PartyNameText).text =
            Parties[position].partyName
        holder.itemView.findViewById<TextView>(R.id.CandidiateNameText).text = Parties[position].Candidate


    }

    override fun getItemCount(): Int {
        return Parties.size
    }

    class PartyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}
