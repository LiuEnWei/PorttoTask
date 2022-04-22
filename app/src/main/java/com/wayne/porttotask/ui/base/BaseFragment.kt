package com.wayne.porttotask.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding>(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    abstract fun bindView(view: View): VB

    private var _binding: VB? = null
    val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = bindView(view)
        init()
    }

    abstract fun init()

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
