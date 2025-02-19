/*
 * Copyright (c) 2021 DuckDuckGo
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

package com.duckduckgo.privacy.config.store

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.duckduckgo.privacy.config.store.features.contentblocking.ContentBlockingDao
import com.duckduckgo.privacy.config.store.features.gpc.GpcDao
import com.duckduckgo.privacy.config.store.features.https.HttpsDao
import com.duckduckgo.privacy.config.store.features.trackerallowlist.TrackerAllowlistDao
import com.duckduckgo.privacy.config.store.features.unprotectedtemporary.UnprotectedTemporaryDao

@TypeConverters(
    RuleTypeConverter::class,
)
@Database(
    exportSchema = true, version = 2,
    entities = [
        TrackerAllowlistEntity::class,
        UnprotectedTemporaryEntity::class,
        HttpsExceptionEntity::class,
        GpcExceptionEntity::class,
        ContentBlockingExceptionEntity::class,
        PrivacyFeatureToggles::class,
        PrivacyConfig::class
    ]
)
abstract class PrivacyConfigDatabase : RoomDatabase() {
    abstract fun trackerAllowlistDao(): TrackerAllowlistDao
    abstract fun unprotectedTemporaryDao(): UnprotectedTemporaryDao
    abstract fun httpsDao(): HttpsDao
    abstract fun gpcDao(): GpcDao
    abstract fun contentBlockingDao(): ContentBlockingDao
    abstract fun privacyFeatureTogglesDao(): PrivacyFeatureTogglesDao
    abstract fun privacyConfigDao(): PrivacyConfigDao
}
