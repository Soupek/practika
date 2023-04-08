package com.example.practica

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import java.util.regex.Pattern

class MainScreen : AppCompatActivity() {

    lateinit var mail:EditText
    lateinit var pass:EditText
    lateinit var button: Button

    val pattern = ("[A-Za-z0-9]{1,100}"+"@"+"[a-z]{1,10}"+"\\."+"[a-z]{1,4}")

    override fun onResume() {
        super.onResume()
        val languages = resources.getStringArray(R.array.languages)

        val spinner = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)

        val adapter = ArrayAdapter(this,
            R.layout.dropdown_item, languages)

        spinner.setAdapter(adapter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        mail = findViewById(R.id.mail)
        pass = findViewById(R.id.pass)
        button = findViewById(R.id.button)
        mail.addTextChangedListener(TextWatcher)
        pass.addTextChangedListener(TextWatcher)

    }
    private val TextWatcher = object:TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val usernameInput: String = mail.text.toString().trim()
            val passwordInput: String = pass.text.toString().trim();
            button.isEnabled = usernameInput.isNotEmpty()&&passwordInput.isNotEmpty()


        }

        override fun afterTextChanged(p0: Editable?) {

        }
    }

    fun emailValid(text:String):Boolean
    {
        return Pattern.compile(pattern).matcher(text).matches()
    }

    fun next(view: View) {
        if (emailValid(mail.text.toString())){
            val intent = Intent(this@MainScreen, newScreen::class.java)
            startActivity(intent)
            finish()
        }
            else {
                Toast.makeText(this, "Ошибка при заполнении Email", Toast.LENGTH_SHORT).show()
            }

    }


}