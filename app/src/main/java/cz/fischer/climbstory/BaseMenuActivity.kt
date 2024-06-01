package cz.fischer.climbstory

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationBarView

abstract class BaseActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    protected lateinit var bottomNavigationView: NavigationBarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResourceId())

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                if (this !is MainActivity) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                return true
            }
            R.id.nav_statistics -> {
//                if (this !is StatisticsActivity) {
//                    startActivity(Intent(this, StatisticsActivity::class.java))
//                    finish()
//                }
                return true
            }
            R.id.nav_add_ascent -> {
//                if (this !is AddEditAscentActivity) {
//                    startActivity(Intent(this, AddEditAscentActivity::class.java))
//                    finish()
//                }
                return true
            }
            R.id.nav_settings -> {
                if (this !is SettingsActivity) {
                    startActivity(Intent(this, SettingsActivity::class.java))
                    finish()
                }
                return true
            }
        }
        return false
    }

    protected abstract fun getLayoutResourceId(): Int

    protected fun updateNavigationBarState(actionId: Int) {
        bottomNavigationView.menu.findItem(actionId).isChecked = true
    }
}
