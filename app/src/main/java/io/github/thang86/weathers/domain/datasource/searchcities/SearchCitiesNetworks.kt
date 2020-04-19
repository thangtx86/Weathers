//package io.github.thang86.weathers.domain.datasource.searchcities
//
//import com.algolia.search.saas.places.PlacesClient
//import com.algolia.search.saas.places.PlacesQuery
//import com.squareup.moshi.Moshi
//import io.github.thang86.weathers.domain.model.SearchResponse
//import io.reactivex.Single
//
//class SearchCitiesNetworks constructor(private val client: PlacesClient, private val moshi: Moshi) {
//    fun findCityByQuery(query: String): Single<SearchResponse> {
//        return Single.create { it ->
//            val searchQuery = PlacesQuery(query).setLanguage("en").setHitsPerPage(25)
//
//            client.searchAsync(searchQuery) { json, exception ->
//                if (exception == null) {
//                    try {
//                        val adapter = moshi.adapter<SearchResponse>(SearchResponse::class.java)
//                        val data = adapter.fromJson(json.toString())
//                        if (data?.hits != null) {
//                            it.onSuccess(data)
//                        }
//                    } catch (e: Throwable) {
//                        println("ThangTX2" + e.localizedMessage)
//                    }
//
//                } else {
//                    it.onError(Throwable("Khong tim thay  '$query'. Thu lai di"))
//                }
//            }
//
//
//        }
//    }
//}