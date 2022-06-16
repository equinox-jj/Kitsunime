package com.kitsunime.common

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import coil.load
import com.google.android.material.imageview.ShapeableImageView
import com.kitsunime.R
import com.kitsunime.data.remote.model.*

object BindingAdapter {

    @BindingAdapter("android:title")
    @JvmStatic
    fun title(view: TextView, data: Titles) {
        if (data.en != null) {
            view.text = data.en
        } else if (data.enUs != null) {
            view.text = data.enUs
        } else if (data.enJp != null) {
            view.text = data.enJp
        } else if (data.jaJp != null) {
            view.text = data.jaJp
        }
    }

    @BindingAdapter("android:original_title")
    @JvmStatic
    fun originalTitle(view: TextView, data: Attributes) {
        view.text = data.canonicalTitle
    }

    @BindingAdapter("android:category")
    @JvmStatic
    fun category(view: AppCompatTextView, data: Data?) {
        val mapping = data?.relationships?.categories?.data
        mapping?.let {
            if (it.size > 1) {
                view.text = "Category : ${mapping[0].id}"
            }
        }
    }

    @BindingAdapter("android:release")
    @JvmStatic
    fun releaseDate(view: AppCompatTextView, data: Attributes) {
        view.text = "Release Date : ${data.startDate}"
    }

    @BindingAdapter("android:type")
    @JvmStatic
    fun type(view: AppCompatTextView, data: Attributes) {
        view.text = data.subtype?.replaceFirstChar { it.uppercase() }
    }

    @BindingAdapter("android:status")
    @JvmStatic
    fun status(view: AppCompatTextView, data: Attributes) {
        view.text = data.status?.replaceFirstChar { it.uppercase() }
    }

//    @BindingAdapter("android:total_chapter")
//    @JvmStatic
//    fun mangaChapter(view: AppCompatTextView, data: Attributes) {
//        if (data.chapterCount != null) {
//            view.text = "${data.chapterCount} Chapters"
//        } else view.text = "Total Unknown"
//    }
//
//    @BindingAdapter("android:total_volume")
//    @JvmStatic
//    fun mangaVolume(view: AppCompatTextView, data: Attributes) {
//        if (data.volumeCount != null) {
//            view.text = data.volumeCount.toString()
//        } else view.text = "Total Unknown"
//    }

    @BindingAdapter("android:total_episode")
    @JvmStatic
    fun animeTotalEpisode(view: AppCompatTextView, data: Attributes) {
        if (data.episodeCount != null) {
            view.text = "Total Episodes : ${data.episodeCount} Episodes"
        } else view.text = "Ongoing"
    }

    @BindingAdapter("android:episode_length")
    @JvmStatic
    fun animeEpisodeLength(view: AppCompatTextView, data: Attributes) {
        if (data.episodeLength != null) {
            view.text = "Duration : ${data.episodeLength} Minutes"
        } else view.text = "Duration Unknown"
    }

    @BindingAdapter("android:poster_shape")
    @JvmStatic
    fun posterShape(view: ShapeableImageView, data: PosterImage?) {
        view.load(data?.large) {
            crossfade(200)
            error(R.drawable.color_gradient)
        }
    }

    @BindingAdapter("android:cover_image")
    @JvmStatic
    fun coverImage(view: AppCompatImageView, data: CoverImage?) {
        view.load(data?.large) {
            crossfade(200)
            error(R.drawable.color_gradient)
        }
    }

    @BindingAdapter("android:poster")
    @JvmStatic
    fun poster(view: ImageView, data: PosterImage?) {
        view.load(data?.large) {
            crossfade(200)
            error(R.drawable.color_gradient)
        }
    }

}