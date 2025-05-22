package com.sravani.myviewmodel

class MyViewModelStore {
    private val map = mutableMapOf<String, MyViewModel>()

    fun get(key: String): MyViewModel? = map[key]

    fun put(key: String, viewModel: MyViewModel) {
        map[key] = viewModel
    }
    fun clear() {
        map.values.forEach { it.onCleared() }
        map.clear()
    }
}