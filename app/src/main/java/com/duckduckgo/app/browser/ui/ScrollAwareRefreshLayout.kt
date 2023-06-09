/*
 * Copyright (c) 2020 DuckDuckGo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duckduckgo.app.browser.ui

import android.content.Context
import android.util.AttributeSet
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class ScrollAwareRefreshLayout(
    context: Context,
    attrs: AttributeSet?,
) : SwipeRefreshLayout(context, attrs) {

    private var canChildScrollUpCallback: (() -> Boolean)? = null

    fun setProgressViewStartOffset(start: Int) {
        mOriginalOffsetTop = start
    }

    override fun canChildScrollUp(): Boolean {
        return canChildScrollUpCallback?.invoke() ?: super.canChildScrollUp()
    }

    fun setCanChildScrollUpCallback(callback: () -> Boolean) {
        canChildScrollUpCallback = callback
    }

    fun removeCanChildScrollUpCallback() {
        canChildScrollUpCallback = null
    }
}
