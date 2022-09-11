package binar.academy.chapter3challenge

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentHuruf : Fragment() {
    private lateinit var listHurufList : ArrayList<ListHuruf>
    private lateinit var hurufAdapter : HurufAdapter
    private lateinit var rvHuruf : RecyclerView
    private lateinit var layoutManager : GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_huruf, container, false)
    }

    // Memastikan layout yang dibaca fragment adalah non-null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        "Daftar Huruf".also { activity?.title = it }
        (this.activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
        (this.activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        dataHuruf()
        rvHuruf = view.findViewById(R.id.rvHuruf)
        with(rvHuruf) { setHasFixedSize(true) }
        GridLayoutManager(context, 3).also { layoutManager = it }
        layoutManager.also { rvHuruf.layoutManager = it }
        HurufAdapter(listHurufList,layoutManager).also { hurufAdapter = it }
        hurufAdapter.also { rvHuruf.adapter = it }
    }

    // Membuat opsi menu mengikuti model menu yang ada
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        this.activity?.menuInflater?.inflate(R.menu.header_bar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    // Menentukan item mana yang akan ditekan
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btnSwapLayout -> {
                when (layoutManager.spanCount) {
                    3 -> {
                        layoutManager.spanCount = 1
                        item.setIcon(R.drawable.ic_grid).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
                    }
                    else -> {
                        layoutManager.spanCount = 3
                        item.setIcon(R.drawable.ic_list).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
                    }
                }
                hurufAdapter.notifyItemRangeChanged(0,hurufAdapter.itemCount)
            } else -> {
            return false
            }
        }
        return true
    }

    private fun dataHuruf() {
        arrayListOf(
            ListHuruf("A"),
            ListHuruf("B"),
            ListHuruf("C"),
            ListHuruf("D"),
            ListHuruf("E"),
            ListHuruf("F"),
            ListHuruf("G"),
            ListHuruf("H"),
            ListHuruf("I"),
            ListHuruf("J"),
            ListHuruf("K"),
            ListHuruf("L"),
            ListHuruf("M"),
            ListHuruf("N"),
            ListHuruf("O"),
            ListHuruf("P"),
            ListHuruf("Q"),
            ListHuruf("R"),
            ListHuruf("S"),
            ListHuruf("T"),
            ListHuruf("U"),
            ListHuruf("V"),
            ListHuruf("W"),
            ListHuruf("X"),
            ListHuruf("Y"),
            ListHuruf("Z")
        ).also { listHurufList = it }
    }
}