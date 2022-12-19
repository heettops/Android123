package com.example.e_grettings.Activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.e_grettings.Client.Apiclient
import com.example.e_grettings.Interface.Apiinterface
import com.example.e_grettings.R
import com.example.e_grettings.databinding.ActivityLoginBinding
import com.example.e_grettings.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    lateinit var apiinterface: Apiinterface
    lateinit var sharedPreferences : SharedPreferences




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnRegister.setOnClickListener{

            var fname=binding.edtFirstName.text.toString()
            var lname=binding.edtLastName.text.toString()
            var phone=binding.edtPhone.text.toString()
            var email=binding.edtEmail.text.toString()
            var pass=binding.edtPassword.text.toString()
            var cpass=binding.edtConfirmPassword.text.toString()

            if(pass.length==0 || cpass.length==0)


            {
                Toast.makeText(applicationContext,"please enter proper password",Toast.LENGTH_LONG).show()
            }

            if (pass.equals(cpass))
            {
                if (fname.length==0)

                {
                    binding.edtFirstName.setError("please enter your first name")
                }

                else if (lname.length==0)

                {
                    binding.edtLastName.setError("please enter your last name")
                }

                else if (phone.length!==0)
                {
                    binding.edtPhone.setError("please enter phone number")
                }


                else if (email.length==0)

                {
                    binding.edtEmail.setError("please enter email")
                }


                else
                {
                    apiinterface=Apiclient.getapiclient().create(Apiinterface::class.java)
                    var registercall : Call<Void> = apiinterface.registerdetail(fname,lname,phone,email,pass)

                    registercall.enqueue(object :Callback<Void>

                    {
                        override fun onResponse(call: Call<Void>, response: Response<Void>) {

                            startActivity(Intent(applicationContext,Login::class.java))

                        }

                        override fun onFailure(call: Call<Void>, t: Throwable)


                        {
                            Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                        }


                    })


                }

            }

            else

            {
                Toast.makeText(applicationContext,"Password and confirm password are not same",Toast.LENGTH_LONG).show()
            }

        }


        binding.btnAlreadyAccount.setOnClickListener {

            startActivity(Intent(this,Login::class.java))

        }



    }
}