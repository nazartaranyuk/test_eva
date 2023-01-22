package com.nazartaraniuk.unsplashtesttask.presentation.main_screen

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.nazartaraniuk.unsplashtesttask.MainApplication
import com.nazartaraniuk.unsplashtesttask.R
import com.nazartaraniuk.unsplashtesttask.databinding.ActivityHomeBinding
import com.nazartaraniuk.unsplashtesttask.presentation.detail_screen.DetailActivity
import com.nazartaraniuk.unsplashtesttask.presentation.favorites_screen.FavoritesActivity
import com.nazartaraniuk.unsplashtesttask.presentation.main_screen.adapter.PhotosAdapter
import com.nazartaraniuk.unsplashtesttask.presentation.models.PhotoImageUI
import com.nazartaraniuk.unsplashtesttask.utils.attachAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    private var binding: ActivityHomeBinding? = null

    @Inject
    lateinit var viewModel: HomeActivityViewModel

    private val savePhoto: (ImageView, PhotoImageUI) -> Unit = { view, photo ->
        view.setOnClickListener {
            viewModel.savePhoto(photo)
            Glide.with(this)
                .load(R.drawable.ic_favorite)
                .into(view)
        }
    }

    private val openDetails: (PhotoImageUI, ImageView) -> Unit = { photo, view ->
        view.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("photo", photo)
            }
            startActivity(intent)
        }
    }

    private val loadPhoto: (ImageView, String) -> Unit = { view, imgUrl ->
        Glide.with(this)
            .load(imgUrl)
            .into(view)
    }

    private val adapter by lazy {
        PhotosAdapter(
            loadPhoto = loadPhoto,
            savePhoto = savePhoto,
            openDetails = openDetails
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        binding?.let { binding ->
            setContentView(binding.root)
            adapter.attachAdapter(binding, this)
            (application as MainApplication).appComponent.inject(this)
            viewModel.loadPhotos()
            lifecycleScope.launch(Dispatchers.Main) {
                viewModel.stateFlow.collect { photos ->
                    adapter.updateList(photos)
                }
            }
            binding.tvGoFavorites.setOnClickListener {
                startActivity(Intent(this, FavoritesActivity::class.java))
            }
        }
    }
}