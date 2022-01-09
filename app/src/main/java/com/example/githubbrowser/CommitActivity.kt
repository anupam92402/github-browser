package com.example.githubbrowser

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubbrowser.databinding.ActivityCommitBinding

class CommitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCommitBinding//view binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //support action bar
        supportActionBar?.hide()
    }
}