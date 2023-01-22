package com.nazartaraniuk.unsplashtesttask.utils

import android.content.Context
import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import android.os.Parcelable
import androidx.recyclerview.widget.LinearLayoutManager
import com.nazartaraniuk.unsplashtesttask.databinding.ActivityFavoritesBinding
import com.nazartaraniuk.unsplashtesttask.databinding.ActivityHomeBinding
import com.nazartaraniuk.unsplashtesttask.presentation.favorites_screen.adapter.FavoritesAdapter
import com.nazartaraniuk.unsplashtesttask.presentation.main_screen.adapter.PhotosAdapter

inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
    SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
}

fun FavoritesAdapter.attachAdapter(binding: ActivityFavoritesBinding, context: Context) {
    with(binding) {
        rvList.adapter = this@attachAdapter
        rvList.layoutManager = LinearLayoutManager(context)
    }
}

fun PhotosAdapter.attachAdapter(binding: ActivityHomeBinding, context: Context) {
    with(binding) {
        rvList.adapter = this@attachAdapter
        rvList.layoutManager = LinearLayoutManager(context)
    }
}

fun String.formatData(): String {
    return this.substring(11, 19) + " " + this.substring(
        0,
        10
    )
}