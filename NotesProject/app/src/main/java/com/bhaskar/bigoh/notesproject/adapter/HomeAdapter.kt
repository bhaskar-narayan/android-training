package com.bhaskar.bigoh.notesproject.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.notesproject.R
import com.bhaskar.bigoh.notesproject.database.NoteDatabase
import com.bhaskar.bigoh.notesproject.database.NoteModel
import com.bhaskar.bigoh.notesproject.ui.MainActivity
import com.bhaskar.bigoh.notesproject.ui.ViewNoteActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeAdapter (val context: MainActivity) : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    private var allNote = listOf<NoteModel>()
    private lateinit var database : NoteDatabase

    class MyViewHolder(itemView: View?) :RecyclerView.ViewHolder(itemView!!) {
        val title: TextView = itemView!!.findViewById(R.id.homeTitle)
        val text : TextView = itemView!!.findViewById(R.id.homeText)
        val container : ConstraintLayout = itemView!!.findViewById(R.id.container)
        val homeDeleteButton: ImageButton = itemView!!.findViewById(R.id.homeDeleteButton)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(allNote: List<NoteModel>, database: NoteDatabase) {
        this.allNote = allNote
        this.database = database
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_adapter_layout,parent,false)
        return HomeAdapter.MyViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: HomeAdapter.MyViewHolder, position: Int) {
        holder.title.text = allNote[position].title
        holder.text.text = allNote[position].text

        holder.container.setOnClickListener {
            val intent = Intent(this.context, ViewNoteActivity::class.java)
            intent.putExtra("title", allNote[position].title)
            intent.putExtra("text", allNote[position].text)
            intent.putExtra("id", allNote[position].id)
            context.startActivity(intent)
        }

        holder.homeDeleteButton.setOnClickListener {
            GlobalScope.launch {
                database.noteDao().deleteNote(allNote[position].id)
            }
            Toast.makeText(it.context, "Note deleted", Toast.LENGTH_SHORT).show()
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = allNote.size

}