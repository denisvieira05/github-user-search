package com.denisvieira05.githubusersearch.domain.usecases

import com.denisvieira05.githubusersearch.data.local.favoriteduser.FavoritedUserLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CheckWasFavoritedUserUseCase @Inject constructor(
    private val localDataSource: FavoritedUserLocalDataSource,
) {
    suspend operator fun invoke(remoteId: Long): Flow<Boolean> = flow {
        val response = localDataSource.findByRemoteId(remoteId)
        val isFavorite = response != null

        emit(isFavorite)
    }
}