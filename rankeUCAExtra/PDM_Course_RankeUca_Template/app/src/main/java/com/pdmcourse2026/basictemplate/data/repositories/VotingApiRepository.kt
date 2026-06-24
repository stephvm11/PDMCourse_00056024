package com.pdmcourse2026.basictemplate.data.repositories

import com.pdmcourse2026.basictemplate.data.api.KtorClient
import com.pdmcourse2026.basictemplate.data.api.Option.CreateVoteDto
import com.pdmcourse2026.basictemplate.data.api.Option.OptionDto
import com.pdmcourse2026.basictemplate.data.api.Option.VoteDto
import com.pdmcourse2026.basictemplate.data.api.Option.toModel
import com.pdmcourse2026.basictemplate.model.Option
import com.pdmcourse2026.basictemplate.model.Vote
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post

class VotingApiRepository : VotingRepository{
    override suspend fun getOptions(): Result<List<Option>> {
        try {
            val request: List<OptionDto> = KtorClient.client.get("options").body()
            return Result.success(request.map { optionDto -> optionDto.toModel() })
        }catch (e : Exception){
            return Result.failure(e)
        }
    }

    override suspend fun getResults(): Result<List<Option>> {
        try {
            val request: List<OptionDto> = KtorClient.client.get("/options").body()
            return Result.success(request.map {optionDto -> optionDto.toModel()})
        }catch (e : Exception){
            return Result.failure(e)

        }
    }

    override suspend fun createVote(id: Int): Result<Vote> {
        try {
            val request = CreateVoteDto(optionId = id)
            val response: VoteDto = KtorClient.client.post("/vote").body()
            return Result.success(response.toModel())
        } catch (e : Exception){
            return Result.failure(e)
        }
    }
}