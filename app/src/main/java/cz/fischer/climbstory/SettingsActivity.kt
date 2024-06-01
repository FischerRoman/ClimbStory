package cz.fischer.climbstory

import android.os.Bundle

class SettingsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateNavigationBarState(R.id.nav_settings)
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_settings
    }
}
