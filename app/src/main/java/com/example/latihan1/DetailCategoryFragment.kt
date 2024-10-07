package com.example.latihan1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class DetailCategoryFragment : Fragment() , View.OnClickListener{
    // TODO: Rename and change types of parameters


    private lateinit var tvCategoryname : TextView
    private lateinit var tvCategoryDescription : TextView
    private lateinit var btnProfile : Button
    private lateinit var btnShowDialog : Button

    var descripton: String? = null

    companion object{
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvCategoryname = view.findViewById(R.id.tv_category_name)
        tvCategoryDescription = view.findViewById(R.id.tv_category_des)
        btnProfile = view.findViewById(R.id.btn_profile)
        btnShowDialog = view.findViewById(R.id.btn_show_dialog)

        if(savedInstanceState != null){
            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            descripton = descFromBundle
        }

        if(arguments != null){
            val categoryName = arguments?.getString(EXTRA_NAME)
            val categoryDesc = arguments?.getString(EXTRA_DESCRIPTION)
            tvCategoryname.text = categoryName
            tvCategoryDescription.text = categoryDesc

        }

        btnProfile.setOnClickListener(this)
        btnShowDialog.setOnClickListener{
            val optionDialogFragment = OptionDialogFragment()

            val fragmentmanager = childFragmentManager
            optionDialogFragment.show(fragmentmanager,OptionDialogFragment::class.java.simpleName)
        }
    }

    internal val optionDialogListener : OptionDialogFragment.OnOptionDialogListener = object : OptionDialogFragment.OnOptionDialogListener {
        override fun onOptionChosen(text: String?) {
            Toast.makeText(requireActivity(),text,Toast.LENGTH_SHORT).show()
        }
    }



    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_profile -> {

            }

        }
    }


}