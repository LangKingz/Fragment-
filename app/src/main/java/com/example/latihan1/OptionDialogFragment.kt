package com.example.latihan1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment


class OptionDialogFragment : DialogFragment() {

    private lateinit var btnChoose : Button
    private lateinit var btnClose : Button
    private lateinit var rgOption : RadioGroup
    private lateinit var rbSaf : RadioButton
    private lateinit var rbMou : RadioButton
    private lateinit var rbLvg : RadioButton
    private lateinit var rbMoyes : RadioButton
    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnClose = view.findViewById(R.id.btn_close)
        btnChoose = view.findViewById(R.id.btn_choose)
        rgOption = view.findViewById(R.id.rg_option)
        rbSaf = view.findViewById(R.id.radioButton1)
        rbMou = view.findViewById(R.id.radioButton2)
        rbLvg = view.findViewById(R.id.radioButton3)
        rbMoyes = view.findViewById(R.id.radioButton4)

        btnChoose.setOnClickListener{
            val checkedRadiobtnID = rgOption.checkedRadioButtonId
            if(checkedRadiobtnID != -1){
                var coach:String = when(checkedRadiobtnID){
                    R.id.radioButton1 -> rbSaf.text.toString().trim()
                    R.id.radioButton2 -> rbMou.text.toString().trim()
                    R.id.radioButton3 -> rbLvg.text.toString().trim()
                    R.id.radioButton4 -> rbMoyes.text.toString().trim()
                    else -> "None"
                }
                optionDialogListener?.onOptionChosen(coach)
                dialog?.dismiss()
            }
        }
        btnClose.setOnClickListener{
            dialog?.cancel()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val fragment = parentFragment

        if (fragment is DetailCategoryFragment) {
            this.optionDialogListener = fragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }


    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }


}