package com.helthcare.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.helthcare.R
import com.helthcare.adapter.login.LoginDescAdapter
import com.helthcare.databinding.FragmentLoginDescBinding

class LoginDescFragment : Fragment() {

    private var _binding:FragmentLoginDescBinding?=null
    val binding get()=_binding!!
    private lateinit var dots:Array<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentLoginDescBinding.inflate(inflater,container,false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val limit=createDescData().size
        createDots(limit)
        setCurrentIndicators(0,limit)
        val descAdapter=LoginDescAdapter(createDescData())
        binding.viewpager.adapter=descAdapter

        binding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicators(position,limit)

            }

        })

        binding.llMobileNumber.setOnClickListener {
            findNavController().navigate(R.id.action_loginDescFragment_to_mobileLoginFragment)
        }

        binding.etMobile.setOnClickListener {
            findNavController().navigate(R.id.action_loginDescFragment_to_mobileLoginFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


    fun createDescData():List<String>{
        return listOf<String>(
            "Video consult top doctors from comfort of your home",
            "Read patient stories and book doctor appointment",
            "Get upto 25% off on medicine, health and wellness product",
            "1 Core Indian connect with doctor every year on Health Care"
        )
    }

    fun createDots(limit:Int){
        dots= Array(limit){ TextView(requireContext()) }
        for(i in 0 until limit){
            dots[i].background=ContextCompat.getDrawable(requireContext(),R.drawable.disable_indicators)
            val params = LinearLayout.LayoutParams(15, 15);
            params.setMargins(8, 0, 8, 0)
            binding.llIndicators.addView(dots[i],params)
        }
    }

    fun setCurrentIndicators(position:Int,limit:Int){
        for(i in 0 until limit){
            if (i==position){
                val textView=binding.llIndicators.get(i)
                textView.background=ContextCompat.getDrawable(requireContext(),R.drawable.active_inducators)
                val params = LinearLayout.LayoutParams(20, 20);
                params.setMargins(8, 0, 8, 0)
                textView.layoutParams=params
            }else{
                val textView=binding.llIndicators.get(i)
                textView.background=ContextCompat.getDrawable(requireContext(),R.drawable.disable_indicators)
                val params = LinearLayout.LayoutParams(15, 15);
                params.setMargins(8, 0, 8, 0)
                textView.layoutParams=params
            }
        }
    }

}