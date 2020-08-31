package com.carol.musyoka.superhero.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.carol.musyoka.superhero.R
import com.carol.musyoka.superhero.data.api.ApiHelper
import com.carol.musyoka.superhero.data.api.RetrofitBuilder
import com.carol.musyoka.superhero.data.model.Hero
import com.carol.musyoka.superhero.ui.detail.SuperheroDetails
import com.carol.musyoka.superhero.ui.main.DefaultItemDecorator
import com.carol.musyoka.superhero.ui.main.adapter.MainAdapter
import com.carol.musyoka.superhero.ui.main.viewmodel.MainViewModel
import com.carol.musyoka.superhero.ui.main.viewmodel.ViewModelFactory
import com.carol.musyoka.superhero.utils.Status
import kotlinx.android.synthetic.main.activity_main.*

   const val HERO_ID = "HERO_ID"


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupViewModel()
        setupUI()
        setupObservers()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        superhero_recycler.addItemDecoration(DefaultItemDecorator(4, 6))
        superhero_recycler.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@MainActivity,2)
        }
        intent?.getLongExtra(HERO_ID,-1)
        adapter = MainAdapter(arrayListOf()){heroId ->
            val intent = Intent(this,SuperheroDetails::class.java)
            intent.putExtra(HERO_ID,heroId)
            startActivity(intent)
        }
        superhero_recycler.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getSuperHeroes().observe(this, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        superhero_recycler.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { heroResponse
                            -> retrieveList(heroResponse) }
                    }
                    Status.ERROR -> {
                        superhero_recycler.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        superhero_recycler.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(hero: List<Hero>) {
        adapter.apply {
            addSuperHeroes(hero)
            notifyDataSetChanged()
        }
    }

}
