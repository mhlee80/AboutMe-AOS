package com.example.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Myeong-Hyeon Lee")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        done.setOnClickListener {
//            addNickname(it)
//        }

        binding.myName = myName

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
//        val editText = nickname_edit
//        val textView = nickname_text
//        var doneButton = done

//        textView.text = editText.text
//        editText.visibility = View.GONE
//        doneButton.visibility = View.GONE
//        textView.visibility = View.VISIBLE


        binding.apply {
//            nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()

            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE

//        editText.visibility = View.GONE
//        doneButton.visibility = View.GONE
//        textView.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
