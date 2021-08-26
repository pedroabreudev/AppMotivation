package br.com.diastecnologia.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.diastecnologia.motivation.R
import br.com.diastecnologia.motivation.infra.MotivationConstants
import br.com.diastecnologia.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreferences = SecurityPreferences(this)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        buttonSave.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonSave) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = editName.text.toString()
        if (name != "") {
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))

        } else {
            Toast.makeText(this, "Informe o seu nome!", Toast.LENGTH_SHORT).show()
        }

    }
}