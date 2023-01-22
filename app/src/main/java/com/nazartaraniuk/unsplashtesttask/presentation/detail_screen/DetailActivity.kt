package com.nazartaraniuk.unsplashtesttask.presentation.detail_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.nazartaraniuk.unsplashtesttask.R
import com.nazartaraniuk.unsplashtesttask.databinding.ActivityDetailBinding
import com.nazartaraniuk.unsplashtesttask.presentation.models.PhotoImageUI
import com.nazartaraniuk.unsplashtesttask.utils.formatData
import com.nazartaraniuk.unsplashtesttask.utils.parcelable
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    private var binding: ActivityDetailBinding? = null
    private var photo: PhotoImageUI? = null

    @Inject
    lateinit var viewModel: DetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        binding?.let { binding ->
            setContentView(binding.root)
            photo = intent.parcelable("photo")
            setInterface(binding)

        }
    }

    private fun setInterface(binding: ActivityDetailBinding) {
        Glide.with(this)
            .load(photo?.urls?.regular)
            .into(binding.ivUserImage)
        binding.tvUser.text = photo?.user?.username
        binding.tvData.text = getString(R.string.posted_at, photo?.dataOfCreation?.formatData())
        Glide.with(this)
            .load(photo?.user?.userAvatar?.mediumImage)
            .into(binding.ivUserAvatar)
        binding.btnSave.setOnClickListener {
            photo?.let { image ->
                viewModel.saveImage(image)
            }
        }
    }
}