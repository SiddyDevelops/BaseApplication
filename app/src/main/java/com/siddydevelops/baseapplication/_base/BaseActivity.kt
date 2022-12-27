package com.siddydevelops.baseapplication._base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.siddydevelops.baseapplication._utils.hide
import com.siddydevelops.baseapplication._utils.show
import com.siddydevelops.baseapplication.databinding.ActivityBaseBinding

abstract class BaseActivity<B: ViewBinding> : AppCompatActivity(), BaseView {
    private val binding by lazy { ActivityBaseBinding.inflate(layoutInflater) }

    abstract fun getLayout(): B
    protected open fun hasToolbar(): Boolean = false
    protected open fun setToolbarText(): String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.container.addView(getLayout().root, 0)
        handleToolbar()
    }

    private fun handleToolbar() {
        if (hasToolbar()) {
            supportActionBar?.setDisplayShowTitleEnabled(true)
            binding.toolbar.show()
            binding.toolbar.title = setToolbarText()
        } else {
            binding.toolbar.hide()
        }
    }

    fun setToolBarTitle(value: String) {
        binding.toolbar.title = value
    }

    override fun showLoading() {
        binding.fullScreenLoader.show()
    }

    override fun hideLoading() {
        binding.fullScreenLoader.hide()
    }

    override fun showNoInternetError(retry: () -> Unit) {

    }

    override fun onRetry() {

    }

    override fun showError(error: String) {

    }

    override fun showToast(message: String?) {

    }
}