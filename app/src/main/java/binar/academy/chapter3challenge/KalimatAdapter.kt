package binar.academy.chapter3challenge

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import binar.academy.chaptertigachallenge.R

class KalimatAdapter(private val listKalimatList : ArrayList<ListKalimat>) : RecyclerView.Adapter<KalimatAdapter.WordViewHolder>() {
    class WordViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        fun bindView(listKalimat: ListKalimat) {
            val btnWords = view.findViewById<Button>(R.id.btnLarge)
            btnWords.text = listKalimat.kata
            btnWords.setOnClickListener {
                val activity = view.context as MainActivity
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.google.com/search?q=${listKalimat.kata}")
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_kalimat, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bindView(listKalimatList[position])
    }

    override fun getItemCount(): Int {
        return listKalimatList.size
    }


}