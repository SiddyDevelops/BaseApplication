package com.siddydevelops.baseapplication

import android.os.Bundle
import com.siddydevelops.baseapplication._base.BaseActivity
import com.siddydevelops.baseapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun getLayout() = binding
    override fun hasToolbar() = false
    override fun setToolbarText() = "Profile"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.text.text = "Siddy"
    }
}