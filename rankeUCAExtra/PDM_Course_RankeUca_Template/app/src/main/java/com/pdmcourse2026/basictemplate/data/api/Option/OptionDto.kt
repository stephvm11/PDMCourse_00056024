package com.pdmcourse2026.basictemplate.data.api.Option

import com.pdmcourse2026.basictemplate.model.Option
import kotlinx.serialization.Serializable

@Serializable
data class OptionDto(
    val id: Int,
    val imageUrl: String?,
    val value: String,
)

fun OptionDto.toModel() : Option{
    return Option(
        id = id,
        imageUrl = imageUrl,
        value = value,
    )
}