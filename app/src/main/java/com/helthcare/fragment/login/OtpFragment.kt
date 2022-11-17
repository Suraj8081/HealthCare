package com.helthcare.fragment.login

import `in`.aabhasjindal.otptextview.OTPListener
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.helthcare.R
import com.helthcare.databinding.FragmentOtpBinding
import java.lang.Exception


class OtpFragment : Fragment(), OTPListener {

    var _binding: FragmentOtpBinding? = null
    val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOtpBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reverseTimer(20, binding.tvTimer)

        binding.btnResend.setOnClickListener {
            reverseTimer(20, binding.tvTimer)
        }

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnContinue.setOnClickListener {
            findNavController().navigate(R.id.action_otpFragment_to_loginProfileFragment)
        }

        binding.otp.otpListener = this
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    fun reverseTimer(Seconds: Int, tv: TextView) {
        binding.btnResend.isClickable = false
        binding.btnResend.isEnabled = false
        tv.setTextColor(requireContext().resources.getColor(R.color.black))
        object : CountDownTimer((Seconds * 1000 + 1000).toLong(), 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                var seconds = (millisUntilFinished / 1000).toInt()
                val minutes = seconds / 60
                seconds = seconds % 60

                tv.text = "${String.format("%02d", minutes)}:${String.format("%02d", seconds)}"

                /*tv.text = "TIME : " + String.format("%02d", minutes) + ":" + String.format(
                    "%02d",
                    seconds
                )*/
            }

            override fun onFinish() {
                try{
                    binding.btnResend.isClickable = true
                    binding.btnResend.isEnabled = true
                    tv.setTextColor(requireContext().resources.getColor(R.color.green))
                    tv.text = "OTP Sent"
                }catch (e:Exception){
                    e.printStackTrace()
                }

            }
        }.start()
    }

    override fun onInteractionListener() {
        binding.btnContinue.isClickable = false
        binding.btnContinue.isFocusable = false
        binding.btnContinue.isEnabled = false
        binding.btnContinue.background =
            ContextCompat.getDrawable(requireContext(), R.drawable.disable_button)
    }

    override fun onOTPComplete(otp: String) {
        binding.btnContinue.isClickable = true
        binding.btnContinue.isFocusable = true
        binding.btnContinue.isEnabled = true
        binding.btnContinue.background =
            ContextCompat.getDrawable(requireContext(), R.drawable.active_button)
    }

}