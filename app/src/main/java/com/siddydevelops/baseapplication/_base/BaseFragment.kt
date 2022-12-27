package com.siddydevelops.baseapplication._base

import android.content.Context
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(), BaseView {

    private var baseView: BaseView? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseView) {
            baseView = context
        }
    }

    override fun showError(error: String) {
        baseView?.showError(error)
    }

    override fun showLoading() {
        baseView?.showLoading()
    }

    override fun hideLoading() {
        baseView?.hideLoading()
    }

    override fun showNoInternetError(retry: () -> Unit) {
        baseView?.showNoInternetError(retry)
    }

    override fun showToast(message: String?) {
        baseView?.showToast(message)
    }

    override fun onRetry() {
        baseView?.onRetry()
    }

    fun onBackPressed(){

    }

    interface OnBackPressed {
        fun onBackPressed()
    }
}