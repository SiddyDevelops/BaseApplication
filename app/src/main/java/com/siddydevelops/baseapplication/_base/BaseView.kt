package com.siddydevelops.baseapplication._base

interface BaseView {
    fun onRetry()
    fun showError(error: String)
    fun showLoading()
    fun hideLoading()
    fun showNoInternetError(retry: () -> Unit)
    fun showToast(message: String?)
}