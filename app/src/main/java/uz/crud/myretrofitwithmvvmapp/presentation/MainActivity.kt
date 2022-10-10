package uz.crud.myretrofitwithmvvmapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import uz.crud.myretrofitwithmvvmapp.databinding.ActivityMainBinding
import uz.crud.myretrofitwithmvvmapp.presentation.adapter.UserAdapter
import uz.crud.myretrofitwithmvvmapp.presentation.factory.MainViewModelFactory
import uz.crud.myretrofitwithmvvmapp.presentation.model.UserModel
import uz.crud.myretrofitwithmvvmapp.presentation.repository.UserRepository
import uz.crud.myretrofitwithmvvmapp.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}