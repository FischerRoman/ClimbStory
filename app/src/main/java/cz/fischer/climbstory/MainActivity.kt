package cz.fischer.climbstory

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import cz.fischer.climbstory.models.Ascent
import cz.fischer.climbstory.repository.AscentRepository

class MainActivity : AppCompatActivity() {

    private lateinit var listViewAscents: ListView
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var ascentRepository: AscentRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listViewAscents = findViewById(R.id.listViewAscents)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        ascentRepository = AscentRepository(this)

        /*bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_statistics -> {
                    val intent = Intent(this, StatisticsActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_add_ascent -> {
                    val intent = Intent(this, AddEditAscentActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_settings -> {
                    val intent = Intent(this, SettingsActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        } */

        //loadAscents()
    }

    /*private fun loadAscents() {
        val ascents = ascentRepository.getAllAscents()
        val adapter = AscentAdapter(this, ascents)
        listViewAscents.adapter = adapter
    }*/
}
