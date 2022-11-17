package com.helthcare.fragment.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.helthcare.R
import com.helthcare.databinding.FragmentMobileLoginBinding

class MobileLoginFragment : Fragment() {

   private var _binding:FragmentMobileLoginBinding?=null
    val binding get()=_binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentMobileLoginBinding.inflate(layoutInflater,container,false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.etMobile.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val length=s!!.length
                if (length==10){
                    binding.btnContinue.isClickable=true
                    binding.btnContinue.isFocusable=true
                    binding.btnContinue.isEnabled=true
                    binding.btnContinue.background=ContextCompat.getDrawable(requireContext(),R.drawable.active_button)
                }else{
                    binding.btnContinue.isClickable=false
                    binding.btnContinue.isFocusable=false
                    binding.btnContinue.isEnabled=false
                    binding.btnContinue.background=ContextCompat.getDrawable(requireContext(),R.drawable.disable_button)
                }
            }

        })

        binding.btnContinue.setOnClickListener {
            findNavController().navigate(R.id.action_mobileLoginFragment_to_otpFragment)
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}