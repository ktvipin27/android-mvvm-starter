package com.ktvipin.mvvmstarter.base.viewmodel.factory

/**
 * Created by Vipin KT on 22/05/20
 */
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ktvipin.mvvmstarter.di.scope.ActivityScope
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
@ActivityScope
class ViewModelFactory @Inject constructor(
    private val viewModelsMap: Map<Class<out ViewModel>,
            @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val entry =
            viewModelsMap.entries.find { modelClass.isAssignableFrom(it.key) }
        val creator = entry?.value
            ?: throw IllegalArgumentException("unknown model class $modelClass")
        return creator.get() as T
    }
}