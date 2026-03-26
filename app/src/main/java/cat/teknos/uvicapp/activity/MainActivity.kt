package cat.teknos.uvicapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import cat.teknos.uvicapp.R
import cat.teknos.uvicapp.fragment.CardFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Uvicapp)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        replaceFragment(CardFragment())
        bottomNavigationView.selectedItemId = R.id.card
        bottomNavigationView.setOnItemSelectedListener { item ->
            if (item.itemId == bottomNavigationView.selectedItemId) return@setOnItemSelectedListener false
            when(item.itemId) {
                R.id.timetable -> replaceFragment(CardFragment())
                R.id.events -> replaceFragment(CardFragment())
                R.id.card -> replaceFragment(CardFragment())
                R.id.launcher -> replaceFragment(CardFragment())
                R.id.bbva -> replaceFragment(CardFragment())
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}