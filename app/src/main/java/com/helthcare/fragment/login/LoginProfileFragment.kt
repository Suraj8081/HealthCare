package com.helthcare.fragment.login

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.helthcare.R
import com.helthcare.databinding.FragmentLoginProfileBinding
import java.util.*

class LoginProfileFragment : Fragment() {

    var _binding: FragmentLoginProfileBinding? = null

    val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginProfileBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dob.setOnClickListener {
            datePickerDialog(binding.dob)
        }

        binding.llDob.setOnClickListener {
            datePickerDialog(binding.dob)
        }

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    @SuppressLint("SetTextI18n")
    fun datePickerDialog(dob: TextView) {
        val date = Calendar.getInstance();
        var thisAYear = date.get(Calendar.YEAR).toInt()
        var thisAMonth = date.get(Calendar.MONTH).toInt()
        var thisADay = date.get(Calendar.DAY_OF_MONTH).toInt()
        val datePickerDialog =
            DatePickerDialog(
                requireContext(), R.style.AppTheme_DatePickerDialog,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    thisAMonth = month + 1
                    thisADay = dayOfMonth
                    thisAYear = year
                    dob.text = "$dayOfMonth/$thisAMonth/$year";
                },
                thisAYear,
                thisAMonth,
                thisADay
            ).show()
    }

}