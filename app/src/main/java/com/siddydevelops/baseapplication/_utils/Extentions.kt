package com.siddydevelops.baseapplication._utils

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun <T> AppCompatActivity.createIntent(className: Class<T>, bundle: Intent? = null) {
    val intent = Intent(this, className)
    bundle?.let {
        intent.putExtras(it)
    }
    startActivity(intent)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun String.underLine(): SpannableString {
    val spanStr = SpannableString(this)
    spanStr.setSpan(UnderlineSpan(), 0, spanStr.length, 0)
    return spanStr
}

fun TextView.addLeftDrawable(drawable: Int) {
    setCompoundDrawablesWithIntrinsicBounds(drawable, 0, 0, 0)
}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}

fun String.shiftNextLine() = replace(" ", "\n")

//fun Any.toJson(): String {
//    val gson = Gson()
//    val json = gson.toJson(this)
//    return json
//}

fun View.showSoftKeyboard() {
    post {
        if (this.requestFocus()) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}

fun EditText.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}