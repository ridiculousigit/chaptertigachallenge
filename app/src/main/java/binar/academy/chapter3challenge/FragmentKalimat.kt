package binar.academy.chapter3challenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FragmentKalimat(private var getHuruf : String) : Fragment() {
    private lateinit var daftarKata : ArrayList<ListKalimat>
    private lateinit var kalimatAdapter : KalimatAdapter
    private lateinit var rvKata : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kalimat, container, false)
    }

    // Memastikan layout yang dibaca fragment adalah non-null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataKata(getHuruf)
        "Kata yang diawali oleh huruf $getHuruf".also { activity?.title = it }
        (this.activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        (this.activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        rvKata = view.findViewById(R.id.recyclerViewWords)
        with(rvKata) { setHasFixedSize(true) }
        LinearLayoutManager(context).also { rvKata.layoutManager = it }
        KalimatAdapter(daftarKata).also { kalimatAdapter = it }
        kalimatAdapter.also { rvKata.adapter = it }
    }

    private fun dataKata(isiKata : String) {
        daftarKata = if (isiKata == "A") arrayListOf(
            ListKalimat("Apel"),
            ListKalimat("Alpukat"),
            ListKalimat("Anggur"))
        else if (isiKata == "B") arrayListOf(
            ListKalimat("Badak"),
            ListKalimat("Bebek"),
            ListKalimat("Buaya"))
        else if (isiKata == "C") arrayListOf(
            ListKalimat("Chile"),
            ListKalimat("Cina"),
            ListKalimat("Costa"))
        else if (isiKata == "D") arrayListOf(
            ListKalimat("Desainer"),
            ListKalimat("Diplomat"),
            ListKalimat("Dokter"))
        else if (isiKata == "E") arrayListOf(
            ListKalimat("Ear"),
            ListKalimat("Elbow"),
            ListKalimat("Eye"))
        else if (isiKata == "F") arrayListOf(
            ListKalimat("Fiji"),
            ListKalimat("Finland"),
            ListKalimat("France"))
        else if (isiKata == "G") arrayListOf(
            ListKalimat("Gecko"),
            ListKalimat("Giraffe"),
            ListKalimat("Gorilla"))
        else if (isiKata == "H") arrayListOf(
            ListKalimat("Hamburger"),
            ListKalimat("Hash Brown"),
            ListKalimat("Hotdog"))
        else if (isiKata == "I") arrayListOf(
            ListKalimat("Iran"),
            ListKalimat("Iraq"),
            ListKalimat("Israel"))
        else if (isiKata == "J") arrayListOf(
            ListKalimat("Kelapa"),
            ListKalimat("Kelengkeng"),
            ListKalimat("Kesemek"))
        else if (isiKata == "K") arrayListOf(
            ListKalimat("Apel"),
            ListKalimat("Alpukat"),
            ListKalimat("Anggur"))
        else if (isiKata == "L") arrayListOf(
            ListKalimat("Apel"),
            ListKalimat("Alpukat"),
            ListKalimat("Anggur"))
        else if (isiKata == "M") arrayListOf(
            ListKalimat("Mama"),
            ListKalimat("Mami"),
            ListKalimat("Mamak"))
        else if (isiKata == "N") arrayListOf(
            ListKalimat("Nigeria"),
            ListKalimat("Nambia"),
            ListKalimat("Nicaragua"))
        else if (isiKata == "O") arrayListOf(
            ListKalimat("Obrolan"),
            ListKalimat("Omong Kosong"),
            ListKalimat("Oranglain"))
        else if (isiKata == "P") arrayListOf(
            ListKalimat("Pemerintah"),
            ListKalimat("Polisi"),
            ListKalimat("Peraturan"))
        else if (isiKata == "Q") arrayListOf(
            ListKalimat("Quail"),
            ListKalimat("Quetzal"),
            ListKalimat("Quokka"))
        else if (isiKata == "R") arrayListOf(
            ListKalimat("Rajin"),
            ListKalimat("Resik"),
            ListKalimat("Ramah"))
        else if (isiKata == "S") arrayListOf(
            ListKalimat("Sigit"),
            ListKalimat("Santoryu"),
            ListKalimat("Samurai"))
        else if (isiKata == "T") arrayListOf(
            ListKalimat("Teman"),
            ListKalimat("Tetangga"),
            ListKalimat("Tante"))
        else if (isiKata == "U") arrayListOf(
            ListKalimat("Ucap"),
            ListKalimat("Ubi"),
            ListKalimat("UwU"))
        else if (isiKata == "V") arrayListOf(
            ListKalimat("Vaksin"),
            ListKalimat("Varian"),
            ListKalimat("Vampir"))
        else if (isiKata == "W") arrayListOf(
            ListKalimat("Wahyu"),
            ListKalimat("Wahid"),
            ListKalimat("Wali"))
        else if (isiKata == "X") arrayListOf(
            ListKalimat("Xantofil"),
            ListKalimat("Xenon"),
            ListKalimat("X-Drake"))
        else if (isiKata == "Y") arrayListOf(
            ListKalimat("Yasopp"),
            ListKalimat("Yakin"),
            ListKalimat("Yahudi"))
        else if (isiKata == "Z") arrayListOf(
            ListKalimat("Zamrud"),
            ListKalimat("Zakat"),
            ListKalimat("Zebra"))
        else {arrayListOf()}
    }
}