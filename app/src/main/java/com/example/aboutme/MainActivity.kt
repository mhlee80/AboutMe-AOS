package com.example.aboutme

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        done.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        val editText = nickname_edit
        val textView = nickname_text
        var doneButton = done

        textView.text = editText.text
        editText.visibility = View.GONE
        doneButton.visibility = View.GONE
        textView.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
