package com.letuse.spinnertest.WithMovieApi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.letuse.finddoctor.model.TestMovie.popular.Result
import com.letuse.spinnertest.R
import kotlinx.android.synthetic.main.fragment_popular.*
import retrofit2.http.Field

class PopularFragment : Fragment() {

    lateinit var popularViewModel: PopularViewModel
    lateinit var popularSpinner : Spinner
    private var popularArray: List<Result> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel()
    }

    fun viewmodel(){
        popularViewModel = ViewModelProvider(this).get(PopularViewModel::class.java)
        popularViewModel.loadPopular()
        popularViewModel.getPopular().observe(
            viewLifecycleOwner, Observer { result ->
                popularArray = result.results

                val data : MutableList<String> = ArrayList()

                popularArray.forEach {
                    data.add(0,it.original_title)
                }

                val adapter = ArrayAdapter(requireContext(), R.layout.list_item, data)
                (textField.editText as? AutoCompleteTextView)?.setAdapter(adapter)

            }
        )
    }
}