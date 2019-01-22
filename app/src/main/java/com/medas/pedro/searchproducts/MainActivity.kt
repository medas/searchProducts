package com.medas.pedro.searchproducts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.algolia.instantsearch.core.helpers.Searcher
import com.algolia.instantsearch.ui.helpers.InstantSearch


class MainActivity : AppCompatActivity() {

    lateinit var searcher: Searcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searcher = Searcher.create(ALGOLIA_APP_ID, ALGOLIA_SEARCH_API_KEY, ALGOLIA_INDEX_NAME)
        val helper = InstantSearch(this, searcher)

        helper.search() // Start the search with an empty query
    }

    override fun onDestroy() {
        searcher.destroy()
        super.onDestroy()
    }

    companion object {
        const val ALGOLIA_APP_ID = "latency"
        const val ALGOLIA_SEARCH_API_KEY = "3d9875e51fbd20c7754e65422f7ce5e1"
        const val ALGOLIA_INDEX_NAME = "bestbuy"
    }
}
