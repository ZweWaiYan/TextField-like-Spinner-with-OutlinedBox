package com.letuse.spinnertest.WithMealApi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.letuse.spinnertest.R
import com.ppak.firstsmallprojectapplication.model.model.countrymodel.Meal


class CountryFragment : Fragment() {
    lateinit var countryListViewModel: CountryListViewModel
    lateinit var countrySpinner: Spinner
    private var countryArray: List<Meal> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_country, container, false)

        countrySpinner = view.findViewById(R.id.spinner1)
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ovserverViewMoel()
    }

    fun ovserverViewMoel() {
        countryListViewModel = ViewModelProvider(this).get(CountryListViewModel::class.java)
        countryListViewModel.loadCountry()
        countryListViewModel.getCountry().observe(
            viewLifecycleOwner, Observer { result ->
                countryArray = result.meals

                val data: MutableList<String> = ArrayList()

                countryArray.forEach {
                    data.add(0, it.strArea)
                }
                countrySpinner.adapter = context?.let {
                    ArrayAdapter<String>(it,R.layout.support_simple_spinner_dropdown_item,data)
                }
            }
        )

    }

}