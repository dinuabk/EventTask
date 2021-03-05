package com.interview.eventtask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.interview.eventtask.R
import com.interview.eventtask.`interface`.CellClickListener
import com.interview.eventtask.model.EventTaskModel

class TestAdapter (private val context: Context,
                   private val list: ArrayList<EventTaskModel>,
                   private val cellClickListener: CellClickListener
) : RecyclerView.Adapter<TestAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(R.id.txtName)
        val textViewDate: TextView = view.findViewById(R.id.txtDate)
        val textViewTime:TextView = view.findViewById(R.id.txtTime)
        val textViewInfo:TextView = view.findViewById(R.id.txtInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_adapter,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.textViewName.text = data.name;
        holder.textViewDate.text = data.localDate
        holder.textViewTime.text = data.localTime
        holder.textViewInfo.text = data.info

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(data)
        }
    }
}