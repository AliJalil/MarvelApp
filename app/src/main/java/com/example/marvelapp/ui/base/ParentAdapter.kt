package com.example.marvelapp.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.BR
import com.example.marvelapp.R
import com.example.marvelapp.domain.HomeItem
import com.example.marvelapp.ui.home.CharacterAdapter
import java.lang.Exception
import  com.example.marvelapp.domain.HomeItemType

class ParentAdapter<T>(
    private var items: List<T>,
    private var listener: BaseInteractionListener?
) : RecyclerView.Adapter<ParentAdapter.BaseViewHolder>() {

//    abstract val layoutId: R.layout
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
//        return ItemViewHolder(
//            DataBindingUtil.inflate(
//                LayoutInflater.from(parent.context),
//                layoutId,
//                parent,
//                false
//            )
//        )
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            VIEW_ITEM -> {
                ChildViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_character,
                        parent,
                        false
                    )
                )
            }
            VIEW_PARENT -> {
                ParentViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_parent,
                        parent,
                        false
                    )
                )
            }
            else -> throw Exception("UNKNOWN VIEW TYPE")
        }
    }


//    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
//        val currentItem = items[position]
//        when (holder) {
//            is ItemViewHolder -> {
//                holder.binding.setVariable(BR.item, currentItem)
//                holder.binding.setVariable(BR.listener, listener)
//            }
//            is NestedViewHolder ->
//            {
//                holder.binding.setVariable(BR.nestedItem, currentItem)
//            }
//        }
//    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
//            is ChildViewHolder -> bindItem(holder, position)
            is ParentViewHolder -> bindNestedItems(holder, position)
        }
    }


//    private fun bindItem(holder: ChildViewHolder, position: Int) {
//        val titleText = (items[position] as HomeItem<*>).item as String
//        holder.binding.setVariable(BR.title, titleText)
//    }

    private fun bindNestedItems(holder: ParentViewHolder, position: Int) {
        val nestedItems = (items[position] as HomeItem<*>).item as List<*>
//        holder.binding.setVariable(BR.nestedItem, nestedItems)
        holder.binding.setVariable(BR.childAdapter, ChildItemsAdapter(nestedItems, listener!!))

//        val adapter = ChildItemsAdapter(nestedItems, listener!!)
//        holder.binding.apply { parentRecycler.adapter = adapter }
    }


    override fun getItemViewType(position: Int): Int {
        return when ((items[position] as HomeItem<*>).type) {
            HomeItemType.TYPE_CHILD -> VIEW_ITEM
            HomeItemType.TYPE_PARENT -> VIEW_PARENT
        }
    }

    fun setItems(newItems: List<T>) {
        val moviesDiffUtil = DiffUtil.calculateDiff(MarvelDiffUtils(items, newItems))
        items = newItems
        moviesDiffUtil.dispatchUpdatesTo(this)
    }

    override fun getItemCount() = items.size

    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
    class ChildViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)
    class ParentViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)


    companion object {
        private const val VIEW_ITEM = 1
        private const val VIEW_PARENT = 2
    }
}
//
//abstract class BaseAdapter<T>(
//    private var items: List<T>,
//    private var listener: BaseInteractionListener?
//) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {
//
//}


class ChildItemsAdapter<I>(items: List<I>, listener: BaseInteractionListener) :
    BaseAdapter<I>(items, listener) {
    override val layoutId: Int = R.layout.item_character
}