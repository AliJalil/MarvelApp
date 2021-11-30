package com.example.marvelapp.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marvelapp.R
import com.example.marvelapp.ui.base.BaseAdapter

@BindingAdapter(value = ["app:showOnLoading"])
fun <T> showOnLoading(view: View, resources: Resources<T>?) {
    if (resources is Resources.Loading)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter(value = ["app:showOnError"])
fun <T> showOnError(view: View, resources: Resources<T>?) {
    if (resources is Resources.Error)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter(value = ["app:showOnSuccess"])
fun <T> showOnSuccess(view: View, resources: Resources<T>?) {
    if (resources is Resources.Success)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    if (items != null) {
        (view.adapter as BaseAdapter<T>?)?.setItems(items)
    } else {
        (view.adapter as BaseAdapter<T>?)?.setItems(emptyList())
    }
}

@BindingAdapter(value = ["imageUrl"])
fun ImageView.seImageFromUrl(url: String?) {
    this.load(url)
    {
        placeholder(R.drawable.ic_launcher_foreground)
    }
}