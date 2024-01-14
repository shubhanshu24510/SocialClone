package com.shubhans.socialclone.feature_profile.presentation.edit_profile

import com.shubhans.socialclone.feature_profile.domain.model.Skill

data class SkillsState(
    val skills: List<Skill> = emptyList(),
    val selectedSkills: List<Skill> = emptyList()
)
