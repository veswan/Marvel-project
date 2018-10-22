package com.vishwan.marvel.main.domain

import com.vishwan.marvel.app.domain.BaseUseCase
import com.vishwan.marvel.app.model.ComicItem
import com.vishwan.marvel.app.network.enums.SortingOrder
import com.vishwan.marvel.app.network.models.Comics
import com.vishwan.marvel.app.network.utils.getUrl
import com.vishwan.marvel.app.repository.MarvelRepository
import kotlinx.coroutines.experimental.async
import timber.log.Timber
import javax.inject.Inject

class GetComicsUseCase
@Inject constructor(private val marvelRepository: MarvelRepository) : BaseUseCase() {

    suspend fun execute(count: Int, orderBy: SortingOrder): List<ComicItem> {
        Timber.i("Use case called, calling repository!")
        val comics: Comics? = async {
            marvelRepository.getComics(count, orderBy)
        }.await()

        Timber.i("Got response from repository, calling mapping function!")
        return mapComicResponseToComicsList(comics)
    }

    private fun mapComicResponseToComicsList(comics: Comics?): MutableList<ComicItem> {
        Timber.i("Mapping function called, returning list of comics")
        val comicsList: MutableList<ComicItem> = mutableListOf()

        comics?.data?.results?.forEach { result ->
            comicsList.add(
                ComicItem(
                    result.title,
                    result.description as String?,
                    result.issueNumber,
                    result.pageCount,
                    result.thumbnail?.getUrl()
                )
            )
        }

        return comicsList
    }
}