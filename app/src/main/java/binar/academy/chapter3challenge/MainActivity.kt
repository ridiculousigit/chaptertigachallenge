package binar.academy.chapter3challenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onSupportNavigateUp(): Boolean {
        Navigation.findNavController(this, R.id.rvKata).navigate(R.id.action_fragmentKalimat_to_fragmentHuruf)
        return super.onSupportNavigateUp()
    }
}