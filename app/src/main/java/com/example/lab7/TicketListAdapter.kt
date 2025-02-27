package com.example.lab7

import android.app.ProgressDialog.show
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.text.format.DateFormat
import androidx.recyclerview.widget.RecyclerView
import com.example.lab7.databinding.ListItemTicketBinding

class TicketHolder(
    val binding: ListItemTicketBinding)
    : RecyclerView.ViewHolder(binding.root) {
    fun bind(ticket: Ticket) {
        binding.ticketTitle.text = ticket.title
        val formattedDate = DateFormat.format("EEEE, MMM dd, yyyy", ticket.date).toString()
        binding.ticketDate.text = formattedDate
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context,
                "${ticket.title} clicked!",
                Toast.LENGTH_SHORT)
                .show()
        }
        binding.ticketSolved.visibility = if (ticket.isSolved) {
            View.VISIBLE
        } else {
            View.GONE
        }

    }

}


class TicketListAdapter(
    private val tickets: List<Ticket>
) : RecyclerView.Adapter<TicketHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = ListItemTicketBinding.inflate(inflator, parent, false)
        return TicketHolder(binding)
    }

    override fun getItemCount(): Int {
        return tickets.size
    }

    override fun onBindViewHolder(holder: TicketHolder, position: Int) {
        val ticket = tickets[position]
        holder.bind(ticket)
    }
}