package com.sravani.viewmodelinternals

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sravani.myviewmodel.MyViewModel

class CountViewModel : MyViewModel() {
    private var _count  = MutableLiveData<Int>(0)
    var count : LiveData<Int> = _count

    fun incrementCount(){
        _count.value = _count.value?.plus(1)
    }

}