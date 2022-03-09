package com.hugorafaelcosta.roomdatabaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hugorafaelcosta.roomdatabaseapp.database.AppDatabase
import com.hugorafaelcosta.roomdatabaseapp.database.daos.UserDao
import com.hugorafaelcosta.roomdatabaseapp.databinding.ActivityNewUserBinding

class NewUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewUserBinding
    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityNewUserBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        this.database = AppDatabase.getInstance(this)

        this.userDao = this.database.userDao()
    }
}