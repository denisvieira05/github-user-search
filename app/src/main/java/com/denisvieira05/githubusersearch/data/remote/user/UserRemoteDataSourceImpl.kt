package com.denisvieira05.githubusersearch.data.remote.user

import com.denisvieira05.githubusersearch.data.converters.SuggestedUserConverter
import com.denisvieira05.githubusersearch.domain.model.DataOrException
import com.denisvieira05.githubusersearch.domain.model.SuggestedUser
class UserRemoteDataSourceImpl(
    private val api: UserAPI,
    private val suggestedUserConverter: SuggestedUserConverter,
) : UserRemoteDataSource {

    override suspend fun getSuggestedUsers(): DataOrException<List<SuggestedUser>, Exception> {
        return try {
            val response = api.getUsers()
            DataOrException(data = suggestedUserConverter.mapResponse(response), exception = null)
        } catch (exception: Exception) {
            DataOrException(exception = exception, data = null)
        }
    }
}