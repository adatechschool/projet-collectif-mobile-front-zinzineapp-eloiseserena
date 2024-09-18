package com.example.zinzineapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EmissionsActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var emissionAdapter: EmissionAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_emissions)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Faire l'appel GET
        RetrofitInstance.api.getEmissions().enqueue(object : Callback<List<Emission>> {
            override fun onResponse(call: Call<List<Emission>>, response: Response<List<Emission>>) {
                if (response.isSuccessful) {
                    val items = response.body() ?: emptyList()
                    emissionAdapter = EmissionAdapter(items)
                    recyclerView.adapter = emissionAdapter
                    items?.let {
                        for (item in items) {
                            Log.d("Emissions", "Titre: ${item.titre}, Datepub: ${item.datepub}, Duree: ${item.duree}, Url: ${item.url}, Description: ${item.descriptif}")
                        }
                    }


                } else {
                    Log.e("RetrofitError", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Emission>>, t: Throwable) {
                Log.e("RetrofitFailure", "Failed to fetch data: ${t.message}")
            }
        })
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}