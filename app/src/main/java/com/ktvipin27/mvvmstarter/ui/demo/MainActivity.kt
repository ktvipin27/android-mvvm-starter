package com.ktvipin27.mvvmstarter.ui.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.ktvipin27.mvvmstarter.R
import com.ktvipin27.mvvmstarter.base.ViewBindingActivity
import com.ktvipin27.mvvmstarter.databinding.ActivityMainBinding
import kotlin.reflect.KFunction1

class MainActivity : ViewBindingActivity<ActivityMainBinding>() {

    override val viewBinding: KFunction1<LayoutInflater, ActivityMainBinding>
        get() = ActivityMainBinding::inflate

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


}
