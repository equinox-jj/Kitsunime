package com.kitsunime.common

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.kitsunime.data.remote.dto.Attributes

object BindingAdapter {

    @BindingAdapter("animeTitle")
    @JvmStatic
    fun animeTitle(view: AppCompatTextView, attributes: Attributes) {
        view.text = attributes.canonicalTitle
    }

    @BindingAdapter("animeTotalEp")
    @JvmStatic
    fun animeTotalEp(view: AppCompatTextView, attributes: Attributes) {
        if (attributes.episodeCount != null) {
            view.text = "${attributes.episodeCount} Episodes"
        } else view.text = "Episodes Unknown"
    }

    @BindingAdapter("animeDurationEp")
    @JvmStatic
    fun animeDurationEp(view: AppCompatTextView, attributes: Attributes) {
        if (attributes.episodeLength != null) {
            view.text = "${attributes.episodeLength} Minutes"
        } else view.text = "Duration Unknown"
    }

}