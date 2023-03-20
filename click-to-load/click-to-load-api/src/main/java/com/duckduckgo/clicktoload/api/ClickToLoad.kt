/*
 * Copyright (c) 2023 DuckDuckGo
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

package com.duckduckgo.clicktoload.api

import android.webkit.WebView

/** Public interface for the Click to Load feature */
interface ClickToLoad {
    /**
     * This method adds the JS interface for Click to Load to create a bridge between JS and our client.
     * It requires a [WebView] instance and an [ClickToLoadCallback].
     */
    fun addJsInterface(webView: WebView, clickToLoadCallback: ClickToLoadCallback)
}

/**
 * Public interface for the Click to Load callback.
 * It is required to be implemented and passed when calling addJsInterface.
 */
interface ClickToLoadCallback {
    /**
     * This method is called whenever Click to Load has a result to be sent.
     */
    fun onResultReceived()
}
