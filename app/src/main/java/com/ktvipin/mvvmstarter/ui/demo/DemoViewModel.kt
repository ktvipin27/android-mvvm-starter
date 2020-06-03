package com.ktvipin.mvvmstarter.ui.demo

import androidx.lifecycle.viewModelScope
import com.ktvipin.mvvmstarter.base.viewmodel.BaseViewModel
import com.ktvipin.mvvmstarter.data.repository.DemoRepository
import com.ktvipin.mvvmstarter.di.scope.ActivityScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Vipin KT on 22/05/20
 */
@ActivityScope
class DemoViewModel @Inject constructor(private val demoRepository: DemoRepository) :
    BaseViewModel() {

    init {
        viewModelScope.launch {
            val demoResp = demoRepository.getDemo("u12345")
        }
    }
}