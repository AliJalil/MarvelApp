package com.example.marvelapp.ui.base

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.BR
import com.example.marvelapp.R
import com.example.marvelapp.domain.HomeItem
import java.lang.Exception
import  com.example.marvelapp.domain.HomeItemType
import com.example.marvelapp.domain.models.Character
import com.example.marvelapp.ui.home.CharacterAdapter
import com.example.marvelapp.ui.home.CharacterInteractionListener

import com.example.marvelapp.ui.home.HomeAdapter

abstract class ParentAdapter<T>(
    private var items: List<T>,
    private var listener: BaseInteractionListener?
) : RecyclerView.Adapter<ParentAdapter.BaseViewHolder>() {

    abstract val layoutId: Int
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            VIEW_ITEM -> {
                ChildViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        layoutId,
                        parent,
                        false
                    )
                )
            }
            VIEW_PARENT -> {
                ParentViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        layoutId,
                        parent,
                        false
                    )
                )
            }
            else -> throw Exception("UNKNOWN VIEW TYPE")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is ChildViewHolder -> bindItem(holder, position)
            is ParentViewHolder -> bindNestedItems(holder, position)
        }
    }

    private fun bindItem(holder: ChildViewHolder, position: Int) {
        val currentItem = items[position]
        holder.binding.setVariable(BR.item, currentItem)
        holder.binding.setVariable(BR.listener, listener)
    }

    lateinit var childAdapter: CharacterAdapter
    @SuppressLint("NotifyDataSetChanged")
    private fun bindNestedItems(holder: ParentViewHolder, position: Int) {

        val listItems = ((items[position] as HomeItem<*>).myItem) as List<Character>
        childAdapter = CharacterAdapter(listItems, listener as CharacterInteractionListener)
        holder.binding.setVariable(
            BR.childAdapter,
            childAdapter
        )
        childAdapter.notifyDataSetChanged()
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
