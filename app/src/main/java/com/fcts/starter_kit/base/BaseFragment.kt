/*
 * Creator: Rahul Gupta on 20/06/21, 5:20 PM
 * Copyright: All rights reserved Ⓒ 2021 https://github.com/RahulGupta2312
 * Last modified: 20/06/21, 5:20 PM
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or
 *  agreed to in writing, software distributed under the License is distributed on an "AS
 *  IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied. See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.fcts.starter_kit.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import javax.inject.Inject

abstract class BaseFragment<V: ViewDataBinding, VM:BaseViewModel<*>>: Fragment() {

    private  var baseActivity: BaseActivity?=null
    private var rootView:View?=null
    private var viewDataBinding:V? = null

    @Inject
    protected lateinit var viewModel:VM


    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    abstract fun getBindingVariable() :Int

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId():Int


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(requireContext() is BaseActivity){
            baseActivity = requireContext() as BaseActivity

        }
    }

    override fun onDetach() {
        baseActivity=null
        super.onDetach()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false)
        rootView = viewDataBinding?.root
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding?.setVariable(getBindingVariable(),viewModel)
    }

    fun getBaseActivity(): BaseActivity? = baseActivity

    fun getViewDataBinding(): ViewDataBinding? = viewDataBinding


    /**
     * Handle Cases for Token Expire
     * Option 1: Logout User
     * Option 2: Refresh Token
     */
    fun onTokenExpire(){

    }

    /**
     * Check if device is connected to internet
     */
    fun isNetworkConnected():Boolean
    {
        return false
    }

    /**
     * Hide soft keyboard
     */
    fun hideKeyboard(){
        baseActivity?.hideKeyboard()
    }


    override fun onPause() {
        super.onPause()
        hideKeyboard()
    }





}