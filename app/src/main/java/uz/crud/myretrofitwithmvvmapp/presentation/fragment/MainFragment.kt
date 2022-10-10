package uz.crud.myretrofitwithmvvmapp.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import uz.crud.myretrofitwithmvvmapp.databinding.FragmentMainBinding
import uz.crud.myretrofitwithmvvmapp.presentation.adapter.UserAdapter
import uz.crud.myretrofitwithmvvmapp.presentation.factory.MainViewModelFactory
import uz.crud.myretrofitwithmvvmapp.presentation.model.UserModel
import uz.crud.myretrofitwithmvvmapp.presentation.repository.UserRepository
import uz.crud.myretrofitwithmvvmapp.presentation.viewmodel.MainViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var userAdapter: UserAdapter
    private lateinit var userList: List<UserModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        val userRepository = UserRepository()
        viewModel = ViewModelProvider(this, MainViewModelFactory(userRepository)).get(MainViewModel::class.java)
        userList = ArrayList()
        userAdapter = UserAdapter(userList)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.userResponse.observe(viewLifecycleOwner) { response ->
            if (response.isNotEmpty()) {
                Log.e("TAG", "onViewCreated: User Item Size ${response.size}")
                userList = response
                userAdapter.submitList(userList)
                binding.usersRv.adapter = userAdapter
            } else {
                Log.e("TAG", "onViewCreated: UserList bo\'sh")
            }
        }

        viewModel.userError.observe(viewLifecycleOwner) { error ->
            Log.e("TAG", "onCreate: $error")
        }

    }

}