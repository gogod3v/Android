/*
 * Copyright (c) 2019 DuckDuckGo
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

package com.duckduckgo.app.cta.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.duckduckgo.app.cta.ui.CtaId

@Entity(
    tableName = "dismissed_cta",
    indices = [
        Index("ctaId")
    ]
)
data class DismissedCta(
    @PrimaryKey
    var ctaId: CtaId
) {

    class IdTypeConverter {

        @TypeConverter
        fun toId(value: String): CtaId {
            return CtaId.valueOf(value)
        }

        @TypeConverter
        fun fromId(value: CtaId): String {
            return value.name
        }
    }
}

