package com.sravani.myviewmodel

class MyViewModelProvider constructor(
    val viewModelStoreOwner: MyViewModelStoreOwner,
    private val factory: Factory
) {

    interface Factory {
        fun <T : MyViewModel> create(modelClass: Class<T>): T
    }

    fun <T : MyViewModel> get(modelClass: Class<T>): T {
        val key = modelClass.canonicalName ?: throw IllegalArgumentException("Invalid class")
        var viewModel = viewModelStoreOwner.getMyViewModelStore().get(key)
        if (viewModel == null) {
            viewModel = factory.create(modelClass)
            viewModelStoreOwner.getMyViewModelStore().put(key, viewModel)
        }
        return viewModel as T
    }
}