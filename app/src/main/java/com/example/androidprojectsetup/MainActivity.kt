package com.example.androidprojectsetup

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androidprojectsetup.databinding.ActivityMainBinding
import com.example.androidprojectsetup.datastore.DataStoreKeys
import com.example.androidprojectsetup.datastore.DataStoreUtil
import com.example.androidprojectsetup.interfaces.NavigationListener
import com.example.androidprojectsetup.interfaces.OnUpdateListener
import dagger.hilt.android.AndroidEntryPoint
import java.lang.ref.WeakReference
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationListener, OnUpdateListener {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainVM by viewModels()
    companion object {
        lateinit var context: WeakReference<Context>
        lateinit var activity: MainActivity
        var navListener: NavigationListener? = null
        var updateListener: OnUpdateListener? = null
        var authToken: String? = null
    }
    @Inject
    lateinit var dataStoreUtil: DataStoreUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        context = WeakReference(this)
        binding.viewModel = viewModel
//        viewModel.navController = findNavController(R.id.fragmentMain)
        activity = this
        updateListener = this
        navListener = this
    }


    override fun isLockDrawer(isLock: Boolean) {
        /*if (isLock) {
            binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        } else {
            binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        }*/
    }

    /***
     * Open drawer listener
     * */

    override fun openDrawer() {
        try {
       /*     if (binding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
                binding.drawerLayout.closeDrawer(GravityCompat.END)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.END)
            }*/
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getBundle(): Bundle? {
        return intent.extras
    }

    override fun onUpdated(isUpdated: Boolean) {
        if (isUpdated) {
            dataStoreUtil.readObject(
                DataStoreKeys.LOGIN_DATA,
                Any::class.java
            ) { data ->

            }
        }
    }

}