package com.bhaskar.bigoh.combinedapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.bhaskar.bigoh.combinedapp.BR
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.databinding.FragmentNewsViewBinding
import com.bhaskar.bigoh.combinedapp.viewmodels.NewsViewFragmentViewModel
import kotlinx.android.synthetic.main.fragment_news_view.*


class NewsViewFragment : Fragment() {
    private lateinit var binder: FragmentNewsViewBinding
    private lateinit var viewModel: NewsViewFragmentViewModel
    //private lateinit var database: NewsDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = makeApiCall()
    }

    private fun makeApiCall(): NewsViewFragmentViewModel {
        val viewModel = ViewModelProvider(requireActivity())[NewsViewFragmentViewModel::class.java]
        viewModel.getListDataObserver().observe(this, Observer {
            if (it != null) {
                viewModel.setAdapter(it.articles)
                Log.d("API_RESPONSE", it.articles.toString())
            }
            else
                Toast.makeText(requireContext(), "Error fetching", Toast.LENGTH_SHORT).show()
        })
        viewModel.callApi()
        return viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_news_view, container, false)
        binder.setVariable(BR.viewModel, viewModel)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupDataBinding()

    }

    private fun setupDataBinding() {
        newsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@NewsViewFragment.context)
            val decoration = DividerItemDecoration(this@NewsViewFragment.context, VERTICAL)
            addItemDecoration(decoration)
        }
        binder.executePendingBindings()
    }
}