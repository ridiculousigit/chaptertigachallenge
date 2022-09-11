package binar.academy.chapter3challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HurufAdapter(private val listHurufList: ArrayList<ListHuruf>, private val layoutManager: GridLayoutManager):
    RecyclerView.Adapter<HurufAdapter.HurufViewHolder>() {
    private val layoutGrid = 1 // Layout berbentuk Grid (Petak)
    private val layoutList = 2  // Layout berbentuk List (Daftar)

    class HurufViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        // Method tombol huruf kala dalam grid view
        fun gridLayouter(parameterHuruf : ListHuruf){
            val tombolHuruf = itemView.findViewById<Button>(R.id.btnSmall)
            tombolHuruf.text = parameterHuruf.huruf
            tombolHuruf.setOnClickListener {
                val activity = itemView.context as AppCompatActivity
                val fragmentKalimat = FragmentKalimat(tombolHuruf.text.toString())
                with(activity) {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragmentKalimat).addToBackStack("fragment").commit()
                }
            }
        }

        // Method tombol huruf kala dalam list view
        fun listLayouter(parameterHuruf : ListHuruf){
            val tombolHuruf = itemView.findViewById<Button>(R.id.btnLarge)
            tombolHuruf.text = parameterHuruf.huruf
            tombolHuruf.setOnClickListener {
                val activity = itemView.context as AppCompatActivity
                val fragmentKalimat = FragmentKalimat(tombolHuruf.text.toString())
                with(activity) {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragmentKalimat).addToBackStack("fragment").commit()
                }
            }
        }
    }

    // Method untuk membuat objek View Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HurufViewHolder {
        val view = if(viewType == layoutGrid) LayoutInflater.from(parent.context)
            .inflate(R.layout.list_huruf, parent, false) else LayoutInflater.from(parent.context)
                .inflate(R.layout.list_kalimat, parent, false)
        return HurufViewHolder(view)
    }

    // Method untuk menghubungkan data dengan objek View Holder
    override fun onBindViewHolder(holder: HurufViewHolder, position: Int) =
        if(layoutManager.spanCount == 1) holder.listLayouter(listHurufList[position]) else holder.gridLayouter(listHurufList[position])

    // Method untuk menentukan jumlah item yang akan ditampilkan di RecyclerView-nya
    override fun getItemCount(): Int {
        return listHurufList.size
    }

    override fun getItemViewType(position: Int): Int {
        val gridCount: Int = layoutManager.spanCount
        return if(gridCount == 3) {
            layoutGrid // Jika jumlah kolom = 3 maka akan mengembalikan layout berbentuk Grid
        } else {
            layoutList // Selain itu mengembalikan Layout berbentuk List
        }
    }
}