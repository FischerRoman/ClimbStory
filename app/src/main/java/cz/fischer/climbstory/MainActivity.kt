package cz.fischer.climbstory

import android.os.Bundle

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateNavigationBarState(R.id.nav_home)
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_main
    }
}
