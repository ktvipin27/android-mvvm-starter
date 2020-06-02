package com.ktvipin.mvvmstarter.extensions

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.ktvipin.mvvmstarter.delegates.FragmentViewBindingDelegate

/**
 * Created by Vipin KT on 21/05/20
 */
fun <T : ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T) =
    FragmentViewBindingDelegate(this, viewBindingFactory)