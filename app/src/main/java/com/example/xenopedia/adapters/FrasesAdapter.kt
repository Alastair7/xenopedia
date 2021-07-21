package com.example.xenopedia.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xenopedia.Entidad.Frase
import com.example.xenopedia.R
import kotlinx.android.synthetic.main.element_list.view.*

class FrasesAdapter : RecyclerView.Adapter<FrasesAdapter.ViewHolder>() {
    private var frase = emptyList<Frase>()
    var onEditClick: ((Frase) -> Unit)? = null
    var onDeleteClick: ((Frase) -> Unit)? = null
    var onItemClick: ((Frase) -> Unit)? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.element_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = frase[position]

        holder.itemView.elementTitle.text = currentItem.titulo

        // Listeners
        holder.itemView.edit_bttn.setOnClickListener{
            onEditClick?.invoke(currentItem)
        }

        holder.itemView.delete_bttn.setOnClickListener{
            onDeleteClick?.invoke(currentItem)
        }

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItem)
        }

    }



    override fun getItemCount(): Int {
        return frase.size
    }

    fun setFrases(frase: List<Frase>){
        this.frase = frase
        notifyDataSetChanged()
    }
}


