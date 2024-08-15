package com.example.reader

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter (private val books : List<Book>)  : RecyclerView.Adapter<BookAdapter.MyViewHolder>() {

    class MyViewHolder(row : View): RecyclerView.ViewHolder(row) {
        val bookname = row.findViewById<TextView>(R.id.bookname)
        val authorname = row.findViewById<TextView>(R.id.authorname)
        val imageview = row.findViewById<ImageView>(R.id.imageView)
       val Rating = row.findViewById<RatingBar>(R.id.rating)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.book,parent,false)
        return MyViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return  books.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val book = books.get(position)

        holder.bookname.text =book.bookname
        holder.authorname.text = book.authorname
        holder.imageview.setImageResource(book.imageResource)
        holder.Rating.rating = book.rating
    }


}