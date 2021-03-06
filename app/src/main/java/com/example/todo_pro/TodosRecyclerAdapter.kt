package com.example.todo_pro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_pro.database.model.Todo
import com.example.todo_pro.R


class TodosRecyclerAdapter(var items: MutableList<Todo>?) :
    RecyclerView.Adapter<TodosRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo, parent, false);
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items!!.get(position);
        holder.title.setText(item.name)
        holder.description.setText(item.details)
    }

    fun changeData(newItems: MutableList<Todo>) {
        items = newItems;
        notifyDataSetChanged();    }

    override fun getItemCount(): Int = items?.size ?: 0;

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.description)
        val markAsDone: ImageView = itemView.findViewById(R.id.mark_as_done)

    }
}