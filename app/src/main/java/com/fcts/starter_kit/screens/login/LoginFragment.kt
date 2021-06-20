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

package com.fcts.starter_kit.screens.login

import android.os.Bundle
import android.view.View
import com.fcts.starter_kit.BR
import com.fcts.starter_kit.R
import com.fcts.starter_kit.base.BaseFragment
import com.fcts.starter_kit.databinding.LoginFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginFragmentBinding, LoginViewModel>(), LoginNavigator {

    //    Variables
    lateinit var binding: LoginFragmentBinding

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.login_fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = getViewDataBinding() as LoginFragmentBinding
    }


    override fun navigateToHome() {

    }

    override fun navigateToForgotPassword() {

    }

    override fun navigateToSignup() {

    }

    override fun handleError(throwable: Throwable) {

    }

}