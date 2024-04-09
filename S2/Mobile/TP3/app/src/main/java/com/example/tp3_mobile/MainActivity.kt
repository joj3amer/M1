package com.example.tp3_mobile

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nom : EditText = findViewById(R.id.editTextNom)
        val prenom : EditText = findViewById(R.id.editTextPrenom)
        val naissance : EditText = findViewById(R.id.editTextDateNaissance)
        val numero : EditText = findViewById(R.id.editTextTelephone)
        val mail : EditText = findViewById(R.id.editTextAdresseMail)
        val sport : CheckBox = findViewById(R.id.checkbox_sport)
        val musique : CheckBox = findViewById(R.id.checkbox_musique)
        val lecture : CheckBox = findViewById(R.id.checkbox_lecture)
        val programmation : CheckBox = findViewById(R.id.checkbox_Programmation)
        val synchro : ToggleButton = findViewById(R.id.toggle_sync)
        val submit : Button = findViewById(R.id.button2)
        val nomLayout: TextInputLayout = findViewById(R.id.textInputLayoutNom)
        val prenomLayout: TextInputLayout = findViewById(R.id.textInputLayoutPrenom)
        val naissanceLayout: TextInputLayout = findViewById(R.id.textInputLayoutDateNaissance)
        val telephoneLayout: TextInputLayout = findViewById(R.id.textInputLayoutTelephone)
        val mailLayout: TextInputLayout = findViewById(R.id.textInputLayoutAdresseMail)



        naissance.addTextChangedListener(object : TextWatcher {
            private var current = ""
            private val ddmmyyyy = "DDMMYYYY"
            private val cal = Calendar.getInstance()


            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString() != current) {
                    var clean = s.toString().replace("[^\\d.]".toRegex(), "")
                    val cleanC = current.replace("[^\\d.]".toRegex(), "")
                    val cl = clean.length
                    var sel = cl
                    var i = 2
                    while (i <= cl && i < 6) {
                        sel++
                        i += 2
                    }
                    //Fix for pressing delete next to a forward slash
                    if (clean == cleanC) sel--
                    if (clean.length < 8) {
                        clean = clean + ddmmyyyy.substring(clean.length)
                    } else {
                        //This part makes sure that when we finish entering numbers
                        //the date is correct, fixing it otherwise
                        var day = clean.substring(0, 2).toInt()
                        var mon = clean.substring(2, 4).toInt()
                        var year = clean.substring(4, 8).toInt()
                        if (mon > 12) mon = 12
                        cal[Calendar.MONTH] = mon - 1
                        year = if (year < 1900) 1900 else if (year > 2008) 2008 else year
                        cal[Calendar.YEAR] = year
                        // ^ first set year for the line below to work correctly
                        //with leap years - otherwise, date e.g. 29/02/2012
                        //would be automatically corrected to 28/02/2012
                        day = if (day > cal.getActualMaximum(Calendar.DATE)) cal.getActualMaximum(
                            Calendar.DATE
                        ) else day
                        clean = String.format("%02d%02d%02d", day, mon, year)
                    }
                    clean = String.format(
                        "%s/%s/%s", clean.substring(0, 2),
                        clean.substring(2, 4),
                        clean.substring(4, 8)
                    )
                    sel = if (sel < 0) 0 else sel
                    current = clean
                    naissance.setText(current)
                    naissance.setSelection(if (sel < current.length) sel else current.length)
                }
            }


            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {}
        })

        submit.setOnClickListener {


            val nom_text  = nom.text.toString()
            val prenom_text  = prenom.text.toString()
            val naissance_text  = naissance.text.toString()
            val numero_text  = numero.text.toString()
            val mail_text = mail.text.toString()


            val intent = Intent(this, RecapActivity::class.java)

            if (nom_text.isEmpty() || nom_text.contains(Regex("\\d"))) {
                nomLayout.error = "le champ saisi contient une erreur"
            }
            if (prenom_text.isEmpty() || prenom_text.contains(Regex("\\d"))) {
                prenomLayout.error = "le champ saisi contient une erreur"
            }
            val phoneNumberPattern = Regex("^(0|\\+33|0033)[1-9][1-9][0-9]{8}$")
            if (numero_text.isEmpty() || numero_text.matches(phoneNumberPattern)) {
                telephoneLayout.error = "numero de téléphone invalide"
            }
            val emailPattern = Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
            if (mail_text.isEmpty() || !mail_text.matches(emailPattern)) {
                mailLayout.error = "adresse email invalide"
            }

            intent.putExtra("nom", nom_text)
            intent.putExtra("prenom", prenom_text)
            intent.putExtra("naissance", naissance_text)
            intent.putExtra("numero", numero_text)
            intent.putExtra("mail", mail_text)
            if(sport.isChecked){
                intent.putExtra("sport", "sport")
            }
            if(musique.isChecked){
                intent.putExtra("musique", "musique ")
            }
            if(lecture.isChecked){
                intent.putExtra("lecture", "lecture")
            }
            if(programmation.isChecked){
                intent.putExtra("programmation", "programmation")
            }
            if(synchro.isChecked){
                intent.putExtra("synchronisation", "synchronisation")
            }else{
                intent.putExtra("pasSynchronise", "pas synchronisé")
            }
            naissance.text?.clear()
            numero.text?.clear()
            mail.text?.clear()
            sport.isChecked = false
            musique.isChecked = false
            lecture.isChecked = false
            programmation.isChecked = false
            synchro.isChecked = false

            startActivity(intent)

        }

        }



}