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

package com.duckduckgo.clicktoload.impl

import android.webkit.WebView
import com.duckduckgo.app.global.plugins.PluginPoint
import com.duckduckgo.clicktoload.api.ClickToLoad
import com.duckduckgo.clicktoload.api.ClickToLoadCallback
import com.duckduckgo.clicktoload.impl.ClickToLoadInterface.Companion.CLICK_TO_LOAD_INTERFACE
import com.duckduckgo.di.scopes.AppScope
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class RealClickToLoad @Inject constructor(
    private val messageHandlerPlugins: PluginPoint<MessageHandlerPlugin>,
) : ClickToLoad {

    override fun addJsInterface(webView: WebView, clickToLoadCallback: ClickToLoadCallback) {
        webView.addJavascriptInterface(
            ClickToLoadInterface(messageHandlerPlugins, webView, clickToLoadCallback),
            CLICK_TO_LOAD_INTERFACE,
        )
    }
}
