package uz.crud.myretrofitwithmvvmapp.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import uz.crud.myretrofitwithmvvmapp.data.service.RetrofitClient
import uz.crud.myretrofitwithmvvmapp.databinding.FragmentMassageBinding
import uz.crud.myretrofitwithmvvmapp.presentation.adapter.MessageAdapter
import uz.crud.myretrofitwithmvvmapp.presentation.factory.MessageViewModelFactory
import uz.crud.myretrofitwithmvvmapp.presentation.model.MessageModel
import uz.crud.myretrofitwithmvvmapp.presentation.repository.MessageRepository
import uz.crud.myretrofitwithmvvmapp.presentation.viewmodel.MessageViewModel

class MassageFragment : Fragment() {
    private lateinit var binding: FragmentMassageBinding
    private lateinit var viewModel: MessageViewModel
    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messageList: ArrayList<MessageModel>
    private val TAG = "MassageFragment"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View {
        binding = FragmentMassageBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(viewModelStore, MessageViewModelFactory(MessageRepository(RetrofitClient.apiService))).get(MessageViewModel::class.java)
        messageList = ArrayList()
        messageAdapter = MessageAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.messageResponse.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                Log.e(TAG, "onViewCreated Code: ${response.code()}", )
                messageList.addAll(response.body()!!)
                messageAdapter.submitList(messageList)
                binding.messageRv.adapter = messageAdapter
                Log.e(TAG, "onViewCreated Message List size: ${messageList.size}", )
            } else {
                Log.e(TAG, "onViewCreated: ${response.code()}")
            }
        }

    }
}