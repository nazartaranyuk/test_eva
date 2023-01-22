package com.nazartaraniuk.unsplashtesttask.presentation.favorites_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.nazartaraniuk.unsplashtesttask.MainApplication
import com.nazartaraniuk.unsplashtesttask.R
import com.nazartaraniuk.unsplashtesttask.databinding.ActivityFavoritesBinding
import com.nazartaraniuk.unsplashtesttask.presentation.detail_screen.DetailActivity
import com.nazartaraniuk.unsplashtesttask.presentation.favorites_screen.adapter.FavoritesAdapter
import com.nazartaraniuk.unsplashtesttask.presentation.models.PhotoImageUI
import com.nazartaraniuk.unsplashtesttask.utils.attachAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoritesActivity : AppCompatActivity() {

    private var binding: ActivityFavoritesBinding? = null

    @Inject
    lateinit var viewModel: FavoritesViewModel

    private val deletePhoto: (ImageView, PhotoImageUI) -> Unit = { view, photo ->
        viewModel.deletePhoto(photo)
        view.setOnClickListener {
            Glide.with(this)
                .load(R.drawable.ic_not_favorite)
                .into(view)
        }
    }

    private val changeColorToFavorite: (ImageView) -> Unit = { image ->
        Glide.with(this)
            .load(R.drawable.ic_favorite)
            .into(image)
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
        FavoritesAdapter(
            loadPhoto = loadPhoto,
            openDetails = openDetails,
            deletePhoto = deletePhoto,
            changeColor = changeColorToFavorite
        )
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadPhotos()
        lifecycleScope.launch {
            viewModel.stateFlow.collect { list ->
                adapter.updateList(list)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MainApplication).appComponent.inject(this)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        binding?.let { binding ->
            adapter.attachAdapter(binding, this)
            setContentView(binding.root)
            viewModel.loadPhotos()
            lifecycleScope.launch {
                viewModel.stateFlow.collect { list ->
                    adapter.updateList(list)
                }
            }
        }
    }


}