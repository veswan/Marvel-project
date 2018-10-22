package com.vishwan.marvel.main.utils

import com.vishwan.marvel.app.network.models.Comics
import com.vishwan.marvel.app.network.models.Data
import com.vishwan.marvel.app.network.models.Result
import com.vishwan.marvel.app.network.models.Thumbnail

interface Dummy {
    companion object {

        private val DUMMY_THUMBNAIL: Thumbnail =
            Thumbnail("https://i.annihil.us/u/prod/marvel/i/mg/b/a0/5ac525af15ba4/clean", "jpg")
        private val DUMMY_RESULT: Result = Result(
            "X-Men: Blue (2017) #26",
            26,
            "Project: Mothervine has been unleashed, and new mutants are emerging all over the world! Even though these new mutants cannot control their powers, MISS SINISTER can! A new team of X-MEN stand against the WHITE QUEEN, HAVOK, BASTION and MISS SINISTER!",
            32,
            DUMMY_THUMBNAIL
        )
        private val DUMMY_DATA: Data = Data(listOf(DUMMY_RESULT))
        private val DUMMY_COMIC_ITEM: Comics = Comics(DUMMY_DATA)
        val DUMMY_COMIC_ITEM_X_MEN = DUMMY_COMIC_ITEM
    }

}