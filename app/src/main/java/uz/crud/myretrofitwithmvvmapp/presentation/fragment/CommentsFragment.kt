package uz.crud.myretrofitwithmvvmapp.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import uz.crud.myretrofitwithmvvmapp.databinding.FragmentCommentsBinding
import uz.crud.myretrofitwithmvvmapp.presentation.adapter.CommentsAdapter
import uz.crud.myretrofitwithmvvmapp.presentation.factory.CommentsViewModelFactory
import uz.crud.myretrofitwithmvvmapp.presentation.model.CommentsModel
import uz.crud.myretrofitwithmvvmapp.presentation.repository.CommentsRepository
import uz.crud.myretrofitwithmvvmapp.presentation.viewmodel.CommentViewModel

class CommentsFragment : Fragment() {
    private lateinit var binding: FragmentCommentsBinding
    lateinit var viewModel: CommentViewModel
    lateinit var commentsAdapter: CommentsAdapter
    lateinit var commentsList: List<CommentsModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCommentsBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(viewModelStore, CommentsViewModelFactory(CommentsRepository())).get(CommentViewModel::class.java)
        commentsList = ArrayList()
        commentsAdapter = CommentsAdapter(commentsList)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getComments()

        viewModel.commentsResponse.observe(viewLifecycleOwner) { response ->
            if (response.isNotEmpty()) {
                Log.e("TAG", "onViewCreated Item Size: ${response.size}", )
                commentsList = response
                binding.commentsRv.adapter = CommentsAdapter(commentsList)
            } else {
                Toast.makeText(requireActivity(), "Xatolik:(", Toast.LENGTH_SHORT).show()
            }

        }
    }
}