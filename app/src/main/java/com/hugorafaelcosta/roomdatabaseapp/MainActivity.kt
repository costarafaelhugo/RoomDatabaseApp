package com.hugorafaelcosta.roomdatabaseapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hugorafaelcosta.roomdatabaseapp.database.AppDatabase
import com.hugorafaelcosta.roomdatabaseapp.databinding.ActivityNewUserBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}