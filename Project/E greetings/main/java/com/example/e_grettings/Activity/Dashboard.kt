package com.example.e_grettings.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_grettings.Adapter.Dashboardadapter
import com.example.e_grettings.Client.Apiclient
import com.example.e_grettings.Interface.Apiinterface
import com.example.e_grettings.Module.Dashboard_Model
import com.example.e_grettings.R
import com.example.e_grettings.databinding.ActivityDashboardBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Dashboard : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var list : MutableList<Dashboard_Model>
    lateinit var apiinterface: Apiinterface



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        sharedPreferences=getSharedPreferences("user_session", Context.MODE_PRIVATE)

        Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("mob",null),Toast.LENGTH_LONG).show()


        var  layoutManager:RecyclerView.LayoutManager=GridLayoutManager(this,2)
        binding.recycler.layoutManager=layoutManager


        list=ArrayList()

        apiinterface=Apiclient.getapiclient().create(Apiinterface::class.java)


        var dashboardviewdata: Call<List<Dashboard_Model?>?>? =  apiinterface.dashboardviewdata

        dashboardviewdata!!.enqueue(object :Callback<List<Dashboard_Model?>?>

        {
            override fun onResponse
                        (


                call: Call<List<Dashboard_Model?>?>,
                response: Response<List<Dashboard_Model?>?>
            )
            {

                        list=response.body() as MutableList<Dashboard_Model>

                var dashboardadapter = Dashboardadapter(applicationContext,list)
                binding.recycler.adapter= dashboardadapter

            }

            override fun onFailure(call: Call<List<Dashboard_Model?>?>, t: Throwable) {



            }


        })





    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean

    {

        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {

        when(item.itemId){

            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                startActivity(Intent(this,Login::class.java))
            }

        }



        return super.onOptionsItemSelected(item)
    }
}