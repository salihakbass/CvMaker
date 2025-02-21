package com.salihakbas.cvmaker.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Splash : Screen

    @Serializable
    data object Home : Screen

    @Serializable
    data object CreateCv : Screen

    @Serializable
    data object Settings : Screen

    @Serializable
    data object PersonalInfo : Screen

    @Serializable
    data object EducationInfo : Screen

    @Serializable
    data object ExperienceInfo : Screen

    @Serializable
    data object SkillsInfo : Screen

    @Serializable
    data object HobbyInfo : Screen

    @Serializable
    data object ProjectInfo : Screen

    @Serializable
    data object ReferenceInfo : Screen

    @Serializable
    data object TemplateSelection : Screen

    @Serializable
    data object Preview : Screen

    @Serializable
    data object EditCv : Screen

    @Serializable
    data object LanguageInfo : Screen
}