/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.artspace.data

import com.example.artspace.R
import com.example.artspace.model.Artwork

object LocalArtworksDataProvider {
    fun getArtworksData(): List<Artwork> {
        return listOf(
            Artwork(
                imageResourceId = R.drawable.gao_kao,
                titleResourceId = R.string.gao_kao,
                artistResourceId = R.string.artist,
                year = 2023
            ),
            Artwork(
                imageResourceId = R.drawable.halloween,
                titleResourceId = R.string.halloween,
                artistResourceId = R.string.artist,
                year = 2023
            ),
            Artwork(
                imageResourceId = R.drawable.happy_halloween,
                titleResourceId = R.string.happy_halloween,
                artistResourceId = R.string.artist,
                year = 2021
            ),
            Artwork(
                imageResourceId = R.drawable.labour_day,
                titleResourceId = R.string.labour_day,
                artistResourceId = R.string.artist,
                year = 2023
            ),
            Artwork(
                imageResourceId = R.drawable.leo_birthday,
                titleResourceId = R.string.leo_birthday,
                artistResourceId = R.string.artist,
                year = 2021
            ),
            Artwork(
                imageResourceId = R.drawable.qi_xi_fes1,
                titleResourceId = R.string.qi_xi_fes1,
                artistResourceId = R.string.artist,
                year = 2023
            ),
            Artwork(
                imageResourceId = R.drawable.qi_xi_fes2,
                titleResourceId = R.string.qi_xi_fes2,
                artistResourceId = R.string.artist,
                year = 2023
            ),
            Artwork(
                imageResourceId = R.drawable.qi_xi_fes3,
                titleResourceId = R.string.qi_xi_fes3,
                artistResourceId = R.string.artist,
                year = 2023
            ),
            Artwork(
                imageResourceId = R.drawable.qi_xi_fes4,
                titleResourceId = R.string.qi_xi_fes4,
                artistResourceId = R.string.artist,
                year = 2023
            ),
            Artwork(
                imageResourceId = R.drawable.qi_xi_fes5,
                titleResourceId = R.string.qi_xi_fes5,
                artistResourceId = R.string.artist,
                year = 2023
            ),
            Artwork(
                imageResourceId = R.drawable.qing_ming_fes,
                titleResourceId = R.string.qing_ming_fes,
                artistResourceId = R.string.artist,
                year = 2023
            )
        )
    }
}
