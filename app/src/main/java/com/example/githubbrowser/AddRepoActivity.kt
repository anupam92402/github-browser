package com.example.githubbrowser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.githubbrowser.databinding.ActivityAddRepoBinding
import com.example.githubbrowser.models.RepoModal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddRepoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddRepoBinding//view binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //hiding action bar
        supportActionBar?.hide()

        // action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //on click listener on back button
        binding.btnBack.setOnClickListener {
            val intent = Intent(this@AddRepoActivity, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }

        //on click listener on add button
        binding.btnADD.setOnClickListener {
            val owner = binding.ETOrgName.text.toString()
            val repo = binding.ETRepoName.text.toString()

            val url = "https://api.github.com/repos/$owner/$repo"
            val Base_URL = "https://api.github.com/repos/"

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Base_URL)
                .build()

            val retrofitApi = retrofit.create(RetrofitApi::class.java)
            val call: Call<RepoModal> = retrofitApi.getRepo(url)
//            Toast.makeText(this@AddRepoActivity, "$owner $repo", Toast.LENGTH_SHORT).show()
            try{
                call.enqueue(object : Callback<RepoModal> {
                    override fun onResponse(call: Call<RepoModal>, response: Response<RepoModal>) {
                        Log.d("Tag",response.message())
                    }

                    override fun onFailure(call: Call<RepoModal>, t: Throwable) {
                        Log.d("Tag",t.message.toString())
                    }

                })
            }catch (e:Exception){
                Log.d("Tag",e.message.toString())
            }

        }
    }

    //click on back button
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}