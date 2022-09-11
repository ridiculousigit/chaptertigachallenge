package binar.academy.chapter3challenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alphabetsFragment = FragmentHuruf()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, alphabetsFragment)
        fragmentTransaction.commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, FragmentHuruf()).commit()
        return super.onSupportNavigateUp()
    }
}