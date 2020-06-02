package com.ktvipin27.mvvmstarter.base.viewmodel.factory

/**
 * Created by Vipin KT on 22/05/20
 */
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ktvipin27.mvvmstarter.di.scope.ActivityScope
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
@ActivityScope
class ViewModelFactory @Inject constructor(
    private val viewModelsMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = viewModelsMap[modelClass] ?: viewModelsMap.asIterable().firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}