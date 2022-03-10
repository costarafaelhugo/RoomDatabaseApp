package com.hugorafaelcosta.roomdatabaseapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hugorafaelcosta.roomdatabaseapp.database.AppDatabase
import com.hugorafaelcosta.roomdatabaseapp.database.daos.UserDao
import com.hugorafaelcosta.roomdatabaseapp.databinding.ActivityMainBinding
import com.hugorafaelcosta.roomdatabaseapp.databinding.ActivityNewUserBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        this.database = AppDatabase.getInstance(this)

        this.userDao = this.database.userDao()

    }

    override fun onStart() {
        super.onStart()

        loadTotalUsers()

        this.binding.btnNewUser.setOnClickListener {

            openNewUserActivity()

        }

    }

    private fun openNewUserActivity() {
        startActivity(Intent(this, NewUserActivity::class.java))
    }

    private fun loadTotalUsers() {

        this.binding.tvInfoTotalUsers.text = "Carregando..."

        CoroutineScope(Dispatchers.IO).launch {

            val total = userDao.getTotalItems()

            withContext(Dispatchers.Main) {

                binding.tvInfoTotalUsers.text = "Total de usuários: $total"

            }

        }

    }

}