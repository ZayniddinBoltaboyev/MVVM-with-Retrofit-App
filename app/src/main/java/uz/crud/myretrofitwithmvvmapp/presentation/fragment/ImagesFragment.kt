package uz.crud.myretrofitwithmvvmapp.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import uz.crud.myretrofitwithmvvmapp.data.utils.ApiResponse
import uz.crud.myretrofitwithmvvmapp.databinding.FragmentImagesBinding
import uz.crud.myretrofitwithmvvmapp.presentation.adapter.ImagesAdapter
import uz.crud.myretrofitwithmvvmapp.presentation.factory.ImagesViewModelFactory
import uz.crud.myretrofitwithmvvmapp.presentation.repository.ImagesRepository
import uz.crud.myretrofitwithmvvmapp.presentation.viewmodel.ImageViewModel

class ImagesFragment : Fragment() {
    private lateinit var binding: FragmentImagesBinding
    lateinit var viewModel: ImageViewModel
    private lateinit var imagesAdapter: ImagesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        binding = FragmentImagesBinding.inflate(layoutInflater, container, false)
        val imagesRepository = ImagesRepository()
        viewModel = ViewModelProvider(viewModelStore, ImagesViewModelFactory(imagesRepository))[ImageViewModel::class.java]
        imagesAdapter = ImagesAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getImages()

        viewModel.imagesResponse.observe(viewLifecycleOwner) { response ->
            when (response) {
                is ApiResponse.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is ApiResponse.Success -> {
                    binding.progressBar.visibility = View.GONE
                    imagesAdapter.submitList(response.data)
                    binding.imagesRv.adapter = imagesAdapter
                }
                is ApiResponse.Error -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Log.e("TAG", "onViewCreated:${response.code} \n${response.message}")
                    Toast.makeText(requireActivity(), "Xatolik :(", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}