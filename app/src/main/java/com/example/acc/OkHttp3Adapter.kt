package com.example.okhttp3

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.acc.R
import com.squareup.picasso.Picasso

class OkHttp3Adapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val itemlist = mutableListOf<OkHttpItem>()

    fun refresh(list:List<OkHttpItem>) {
        itemlist.apply {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    fun addList(list: List<OkHttpItem>){
        itemlist.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = itemlist.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(
            R.layout.ok_http3, parent, false
        )
        return ItemViewHolder(itemview)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rootView: ConstraintLayout = itemView.findViewById(R.id.rootView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val likeCountTextView: TextView = itemView.findViewById(R.id.likeCountTextView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder)
            onBindViewHolder(holder, position)
    }

    private fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemlist[position]
        holder.titleTextView.text = currentItem.title
        holder.likeCountTextView.text = "${currentItem.likes_count}"
        Picasso.get().load(currentItem.user.profile_image_url).into(holder.imageView)
        holder.rootView.setOnClickListener {
            Toast.makeText(context, "${currentItem.title}", Toast.LENGTH_SHORT).show()
        }
        holder.titleTextView.setOnClickListener{
            // intentにurlを渡すと...
            println("${currentItem.url}")
            val uri=Uri.parse(currentItem.url)
//            val intent = Intent(Intent.ACTION_VIEW ,uri)
//            context.startActivity(intent)

            val intent=Intent(context,WebActivity::class.java)
            intent.putExtra("url","${currentItem.url}")
            context.startActivity(intent)
        }
    }

}