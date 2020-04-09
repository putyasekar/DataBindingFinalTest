package com.diki.idn.databindingfinaltest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.diki.idn.databindingfinaltest.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        et_comment.setOnClickListener {
            val intent = Intent(this, CommentSection::class.java)
            startActivity(intent)
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.mainBainding = mainViewModel
        binding.lifecycleOwner = this

        binding.imageCat = getDrawable(R.drawable.kucing_ig)
    }
}
