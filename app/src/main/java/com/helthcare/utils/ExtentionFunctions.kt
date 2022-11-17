package com.helthcare.utils

import android.content.Context
import java.util.regex.Matcher
import java.util.regex.Pattern

fun Context.validateMobileNumber(number:String):Boolean{
    val ptrn: Pattern = Pattern.compile("(0/91)?[7-9][0-9]{9}")
    val match: Matcher = ptrn.matcher(number)
    return match.find() && match.group().equals(number)
}