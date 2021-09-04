package net.sanic.Kayuri.utils.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class AnimeMetaModel(
    @PrimaryKey
    var ID: Int = 0,
    var typeValue: Int? = null,
    var imageUrl: String = "",
    var categoryUrl: String? = null,
    var episodeUrl: String? = null,
    var title: String = "",
    var episodeNumber: String? = null,
    var genreList: RealmList<GenreModel>? =null,
    var timestamp: Long = System.currentTimeMillis(),
    var insertionOrder: Int = -1,
    var releasedDate: String? =null
): RealmObject()
