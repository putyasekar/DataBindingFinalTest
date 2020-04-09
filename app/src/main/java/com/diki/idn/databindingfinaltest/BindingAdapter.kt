package com.diki.idn.databindingfinaltest

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @BindingAdapter("app:popularityIcon")
    @JvmStatic
    fun popularityIcon(imageView: ImageView, popularity: MainObservableViewModel.LikesNumber) {
        val color = getAssociatedLikesColor(popularity, imageView.context)
        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(color))
        imageView.setImageDrawable(getDrawableLikesPopularity(popularity, imageView.context))
    }

    private fun getDrawableLikesPopularity(
        popularity: MainObservableViewModel.LikesNumber,
        context: Context
    ): Drawable? {
        return when (popularity) {
            MainObservableViewModel.LikesNumber.FAMOUS -> ContextCompat.getDrawable(
                context,
                R.drawable.like_ig
            )
            MainObservableViewModel.LikesNumber.POPULAR -> ContextCompat.getDrawable(
                context,
                R.drawable.like_ig
            )
            MainObservableViewModel.LikesNumber.NORMAL -> ContextCompat.getDrawable(
                context,
                R.drawable.like_ig
            )
        }
    }

    private fun getAssociatedLikesColor(
        popularity: MainObservableViewModel.LikesNumber,
        context: Context
    ): Int {
        return when (popularity) {
            MainObservableViewModel.LikesNumber.FAMOUS -> ContextCompat.getColor(
                context,
                R.color.BLUE
            )
            MainObservableViewModel.LikesNumber.POPULAR -> ContextCompat.getColor(
                context,
                R.color.GREEN
            )
            MainObservableViewModel.LikesNumber.NORMAL -> ContextCompat.getColor(
                context,
                R.color.RED
            )
        }
    }
}