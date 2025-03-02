package com.salihakbas.cvmaker.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CV(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val personalInfo: List<PersonalInfo>,
    )

data class PersonalInfo(
    val name: String,
    val surname: String,
    val email: String,
    val phone: String,
    val website: String,
    val location: String
)

data class EducationInfo(
    val school: String,
    val department: String,
    val startDate: String,
    val endDate: String,
)

data class ExperienceInfo(
    val company: String,
    val position: String,
    val startDate: String,
    val endDate: String,
    val description: String
)

data class LanguageInfo(
    val language: String,
    val level: String
)