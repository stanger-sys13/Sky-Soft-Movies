package com.example.skysoftmovies.ui.tablist

import androidx.appcompat.app.AppCompatActivity

class TabTwoMenu : AppCompatActivity() {
//    private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var navController: NavController
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_tab_two)
//
//        navController = findNavController(R.id.main_nav_host) //Initialising navController
//
////        appBarConfiguration = AppBarConfiguration.Builder(R.id.homeFragment, R.id.accountsFragment,
//            R.id.dashboardFragment) //Pass the ids of fragments from nav_graph which you d'ont want to show back button in toolbar
//            .setDrawerLayout(main_drawer_layout) //Pass the drawer layout id from activity xml
//            .build()
//
//        setSupportActionBar(main_toolbar) //Set toolbar
//
//        setupActionBarWithNavController(navController, appBarConfiguration) //Setup toolbar with back button and drawer icon according to appBarConfiguration
//
//        visibilityNavElements(navController) //If you want to hide drawer or bottom navigation configure that in this function
//    }
//
//    private fun visibilityNavElements(navController: NavController) {

    //Listen for the change in fragment (navigation) and hide or show drawer or bottom navigation accordingly if required
    //Modify this according to your need
    //If you want you can implement logic to deselect(styling) the bottom navigation menu item when drawer item selected using listener

//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.ListFragment -> hideBothNavigation()
//                R.id.TabFragment -> hideBottomNavigation()
//                else -> showBothNavigation()
//            }
//        }
//
//    }
//
//    private fun hideBothNavigation() { //Hide both drawer and bottom navigation bar
//        main_bottom_navigation_view.visibility = View.GONE
//        main_navigation_view.visibility = View.GONE
//    }
//
//    private fun hideBottomNavigation() { //Hide bottom navigation
//        main_bottom_navigation_view.visibility = View.GONE
//        main_navigation_view.visibility = View.VISIBLE
//
//        main_navigation_view.setupWithNavController(navController) //Setup Drawer navigation with navController
//    }
//
//    private fun showBothNavigation() {
//        main_bottom_navigation_view.visibility = View.VISIBLE
//        main_navigation_view.visibility = View.VISIBLE
//        setupNavControl() //To configure navController with drawer and bottom navigation
//    }

//    private fun setupNavControl() {
//        main_navigation_view.setupWithNavController(navController) //Setup Drawer navigation with navController
//        main_bottom_navigation_view.setupWithNavController(navController) //Setup Bottom navigation with navController
//    }

//    fun exitApp() { //To exit the application call this function from fragment
//        this.finishAffinity()
//    }

//    override fun onSupportNavigateUp(): Boolean { //Setup appBarConfiguration for back arrow
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//    }
//
//    override fun onBackPressed() {
//        when { //If drawer layout is open close that on back pressed
//            main_drawer_layout.isDrawerOpen(GravityCompat.START) -> {
//                main_drawer_layout.closeDrawer(GravityCompat.START)
//            }
//            else -> {
//                super.onBackPressed() //If drawer is already in closed condition then go back
//            }
//        }
//    }
//}
}