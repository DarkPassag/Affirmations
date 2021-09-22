package com.ni.che.affirmations.RecyclerView

import android.content.Context
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ni.che.affirmations.DataClases.DataSource
import com.ni.che.affirmations.R
import com.ni.che.affirmations.databinding.ActivityMainBinding
import com.ni.che.affirmations.databinding.ItemBinding

class AffirmationsAdapter(private val context : Context): RecyclerView.Adapter<AffirmationsHolder>() {

    private val dataSource: DataSource = DataSource()

    override fun getItemCount() =  dataSource.loadAffirmations().size



    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : AffirmationsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemBinding = ItemBinding.inflate(inflater, parent, false)
        return AffirmationsHolder(binding)
    }

    override fun onBindViewHolder(holder : AffirmationsHolder, position : Int) {
        val item = dataSource.loadAffirmations()[position]
        val text = holder.itemView.findViewById<TextView>(R.id.textTextView)
        val image = holder.itemView.findViewById<ImageView>(R.id.imageImageView)
        text.text = context.getString(item.stringResId)
        image.setImageResource(item.imageResId)
    }
}