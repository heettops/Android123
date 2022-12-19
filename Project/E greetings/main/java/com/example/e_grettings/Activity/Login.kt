package com.example.e_grettings.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.e_grettings.Client.Apiclient
import com.example.e_grettings.Interface.Apiinterface
import com.example.e_grettings.R
import com.example.e_grettings.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity()


{

    private lateinit var binding: ActivityLoginBinding
    lateinit var apiinterface: Apiinterface
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


         sharedPreferences =getSharedPreferences("user_session",Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("User_Session",false) && !sharedPreferences.getString("mob","")!!.isEmpty())

        {
            startActivity(Intent(this@Login,Dashboard::class.java))
            finish()
        }

        binding.btnlogin.setOnClickListener{

            if (binding.edtPhone.text.toString().length==0)
            {
                binding.edtPhone.setError("Please enter valid phone number")
            }

            else if (binding.edtPassword.text.toString().length==0)

            {
                binding.edtPassword.setError("please enter proper password")
            }

            else
            {
                var phone= binding.edtPhone.text.toString()
                var pass=binding.edtPassword.text.toString()

                apiinterface=Apiclient.getapiclient().create(Apiinterface::class.java)

                var call: Call<com.example.e_grettings.Module.Register> = apiinterface.logindata(phone,pass)

                call.enqueue(object :Callback<com.example.e_grettings.Module.Register>{
                    override fun onResponse(
                        call: Call<com.example.e_grettings.Module.Register>,
                        response: Response<com.example.e_grettings.Module.Register>
                    )

                    {

                        sharedPreferences.edit().putString("phone",phone).commit()
                        sharedPreferences.edit().putBoolean("user_session",true).commit()

                        Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()

                        binding.edtPhone.setText("")
                        binding.edtPassword.setText("")

                        startActivity(Intent(applicationContext,Dashboard::class.java))




                    }

                    override fun onFailure(call: Call<com.example.e_grettings.Module.Register>, t: Throwable) {

                        Toast.makeText(applicationContext,"No Internet Connection",Toast.LENGTH_LONG).show()

                    }


                })

        }




    }

        binding.signup.setOnClickListener{

        startActivity(Intent(this,Register::class.java))


        }



        }

    override fun onBackPressed() {

        finishAffinity()

    }
}