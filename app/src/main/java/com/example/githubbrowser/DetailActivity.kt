package com.example.githubbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.githubbrowser.databinding.ActivityDetailBinding
import com.example.githubbrowser.fragments.BranchFragment
import com.example.githubbrowser.fragments.IssuesFragment

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding//view binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Details"

        val branchFragment = BranchFragment()
        val issueFragment = IssuesFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.FLFragment , branchFragment)
            commit()
        }

        binding.btnBranches.setOnClickListener {
            Toast.makeText(this,"Branch",Toast.LENGTH_SHORT).show()
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLFragment , branchFragment)
                commit()
            }
        }

        binding.btnIssues.setOnClickListener {
            Toast.makeText(this,"Issues",Toast.LENGTH_SHORT).show()
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLFragment , issueFragment)
                commit()
            }
        }
    }

    //menu to add repo
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.delete ->{
                Toast.makeText(this,"Delete",Toast.LENGTH_SHORT).show()
            }
            R.id.visible ->{
                Toast.makeText(this,"Eye",Toast.LENGTH_SHORT).show()
            }

        }
        return true
    }

    //click on back button
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}