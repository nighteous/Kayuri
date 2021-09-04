package net.sanic.Kayuri.utils.helper

import io.realm.Realm
import io.realm.RealmResults
import net.sanic.Kayuri.utils.model.WatchedEpisode
import net.sanic.Kayuri.utils.realm.InitalizeRealm

class WatchedEpisode(animeName: String){
    private var results: RealmResults<WatchedEpisode>? = null
    private val realm = Realm.getInstance(InitalizeRealm.getConfig())
    private val watchedMap: HashMap<Int, Long> = HashMap()

    init {
        results = realm.where(WatchedEpisode::class.java)
            .equalTo("animeName", animeName).findAll()
        updateWatchMap(results)
        results?.addChangeListener { newResult->
            updateWatchMap(newResult)
        }
    }

    private fun updateWatchMap(results: RealmResults<WatchedEpisode>?){
        watchedMap.clear()
        results?.forEach {
            watchedMap[it.id] = it.watchedPercentage ?: 0
        }

    }

    fun isWatched(id: Int): Boolean{
        return watchedMap.containsKey(id)
    }

    fun getWatchedDuration(id: Int): Long{
        return watchedMap[id] ?: 0
    }

}