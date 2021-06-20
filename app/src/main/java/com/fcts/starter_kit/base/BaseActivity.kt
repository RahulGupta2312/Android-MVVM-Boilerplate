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
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {


    fun hideKeyboard(){
        val view = currentFocus
        view?.let {v->
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager?.let {
                it.hideSoftInputFromWindow(v.windowToken,0)
            }
        }
    }

}