package com.pdmcourse2026.basictemplate.data.api.Option

import com.pdmcourse2026.basictemplate.model.Vote
import kotlinx.serialization.Serializable

@Serializable
data class VoteDto(
    val optionId: Int
)

fun VoteDto.toModel(): Vote{
    return Vote(
        optionId = optionId
    )
}