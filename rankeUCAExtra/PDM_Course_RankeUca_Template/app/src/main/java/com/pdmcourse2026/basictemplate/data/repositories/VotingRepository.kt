package com.pdmcourse2026.basictemplate.data.repositories

import com.pdmcourse2026.basictemplate.model.Option
import com.pdmcourse2026.basictemplate.model.Vote

interface VotingRepository {
    suspend fun getOptions() : Result<List<Option>>

    suspend fun getResults(): Result<List<Option>>

    suspend fun createVote(id: Int): Result<Vote>
}