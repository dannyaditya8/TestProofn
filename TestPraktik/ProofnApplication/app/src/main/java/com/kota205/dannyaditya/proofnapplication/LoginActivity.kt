package com.kota205.dannyaditya.proofnapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.kota205.dannyaditya.proofnapplication.client.LoginClient
import com.kota205.dannyaditya.proofnapplication.client.UserClient
import com.kota205.dannyaditya.proofnapplication.model.UserResponse
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import android.widget.Toast
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import com.kota205.dannyaditya.proofnapplication.client.SaveSharedPreferences


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        if (SaveSharedPreferences.getLoggedStatus(applicationContext)) {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        } else {
            nestedScrollView.visibility = View.VISIBLE
        }

        appCompatButtonLogin.setOnClickListener {
            userLogin(textInputEditTextEmail.text.toString(), textInputEditTextPassword.text.toString())
        }
    }

    private fun userLogin(email: String, password: String) {

        val retrofit = LoginClient.getClient()
        val loginServices = retrofit!!.create(UserClient::class.java!!)
        val call = loginServices.userLogin("application/json", email, password)

        Log.d("Message :", call.toString())

        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {

                if (response.isSuccessful) {
                    // Set Logged In statue to 'true'
                    SaveSharedPreferences.setLoggedIn(applicationContext, true)
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                } else {
                    SaveSharedPreferences.setLoggedIn(applicationContext, true)
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("TAG", "=======onFailure: " + t.toString())
                t.printStackTrace()
                // Log error here since request failed
            }
        })
    }

}