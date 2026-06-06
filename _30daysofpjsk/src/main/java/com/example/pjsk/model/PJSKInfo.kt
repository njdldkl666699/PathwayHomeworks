package com.example.pjsk.model

import androidx.annotation.DrawableRes

data class PJSKInfo(
    val character: Character,
    val title: String,
    val dialogue: String,
    val skillName: String,
    val skillDescription: SkillDescription,
    @DrawableRes val drawable: Int,
) {
    companion object {
        fun ofBFes(
            character: Character,
            title: String,
            dialogue: String,
            skillNameNormal: String,
            skillDescriptionNormal: SkillDescription,
            @DrawableRes drawableNormal: Int,
            skillNameTrained: String,
            skillDescriptionTrained: SkillDescription,
            @DrawableRes drawableTrained: Int,
        ): Array<PJSKInfo> {
            return arrayOf(
                PJSKInfo(
                    character,
                    title,
                    dialogue,
                    skillNameNormal,
                    skillDescriptionNormal,
                    drawableNormal,
                ),
                PJSKInfo(
                    character,
                    title,
                    dialogue,
                    skillNameTrained,
                    skillDescriptionTrained,
                    drawableTrained,
                ),
            )
        }

        fun ofNormalAndTrained(
            character: Character,
            title: String,
            dialogue: String,
            skillName: String,
            skillDescription: SkillDescription,
            @DrawableRes drawableNormal: Int,
            @DrawableRes drawableTrained: Int,
        ): Array<PJSKInfo> {
            return arrayOf(
                PJSKInfo(
                    character,
                    title,
                    dialogue,
                    skillName,
                    skillDescription,
                    drawableNormal,
                ),
                PJSKInfo(
                    character,
                    title,
                    dialogue,
                    skillName,
                    skillDescription,
                    drawableTrained,
                ),
            )
        }
    }
}