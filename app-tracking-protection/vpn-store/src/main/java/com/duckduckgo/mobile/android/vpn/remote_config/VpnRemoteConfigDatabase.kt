/*
 * Copyright (c) 2022 DuckDuckGo
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

package com.duckduckgo.mobile.android.vpn.remote_config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    exportSchema = true,
    version = 1,
    entities = [
        VpnConfigToggle::class,
    ],
)
@TypeConverters()
abstract class VpnRemoteConfigDatabase : RoomDatabase() {

    abstract fun vpnConfigTogglesDao(): VpnConfigTogglesDao

    companion object {
        fun create(context: Context): VpnRemoteConfigDatabase {
            return Room.databaseBuilder(context, VpnRemoteConfigDatabase::class.java, "apptp_remote_config.db")
                .enableMultiInstanceInvalidation()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
