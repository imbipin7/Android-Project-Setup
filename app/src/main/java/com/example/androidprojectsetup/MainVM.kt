package com.example.androidprojectsetup

import android.app.AlertDialog
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.androidprojectsetup.datastore.DataStoreKeys
import com.example.androidprojectsetup.datastore.DataStoreUtil
import com.example.androidprojectsetup.networkcalls.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MainVM @Inject constructor(
    private val repository: Repository,
    private val dataStore: DataStoreUtil,
) : ViewModel() {

    val drawerOpen: ObservableField<Boolean> = ObservableField(false)
    private val TAG = "Bipin_Singh"

    lateinit var navController: NavController

    init {
        dataStore.readObject(DataStoreKeys.LOGIN_DATA, Any::class.java) { data ->
//      Set it here
        }


    }



    /** Logout Dialog **/
    private fun showLogout(view: View) {
        val logout = AlertDialog.Builder(view.context)
        logout.setTitle("Are you sure you want to logout?")
        logout.setCancelable(false)
        logout.setPositiveButton("OK") { dialogInterface, _ ->
            dialogInterface.cancel()
            dialogInterface.dismiss()
        }
        logout.setNegativeButton("Cancel") { dialogInterface, _ ->
            dialogInterface.cancel()
            dialogInterface.dismiss()
        }
        logout.create()
        logout.show()
    }



}