package com.example.marvelapp.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.BR
import com.example.marvelapp.domain.Holder


abstract class ParentAdapter<T>(
    private var items: List<T>,
    private var listener: BaseInteractionListener?
) : RecyclerView.Adapter<ParentAdapter.BaseViewHolder>() {

    abstract val layoutId: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = items[position]
        when (holder) {
            is ItemViewHolder -> {
                holder.binding.setVariable(BR.item, currentItem)
                holder.binding.setVariable(BR.listener, listener)
            }
            is NestedViewHolder ->
            {
                holder.binding.setVariable(BR.nestedItem, currentItem)
            }
        }


//        when (holder) {
//            Holder.PARENT.type -> {
//                with(binding) {
//                    setVariable(BR.dataItem, dataObject as Pdo)
//                    executePendingBindings()
//                    root.setOnClickListener(this@ViewHolder)
//                }
//            }
//            Holder.NESTED.type -> {
//                val nestedAdapter = NestedAdapter(parentPosition).apply {
//                    setOnClickListenerNested(onClickListener)
//                    setData(dataList = (dataObject as NestedDataObjectWrapper).nestedDataObjectList)
//                }
//                with(binding) {
//                    setVariable(BR.adapter, nestedAdapter)
//                    executePendingBindings()
//                    root.setOnClickListener(this@ViewHolder)
//                }
//            }
//        }
    }

    fun setItems(newItems: List<T>) {
        val moviesDiffUtil = DiffUtil.calculateDiff(MarvelDiffUtils(items, newItems))
        items = newItems
        moviesDiffUtil.dispatchUpdatesTo(this)

    }

    fun getItems() = items

    override fun getItemCount() = items.size

    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)
    class NestedViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)

    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

}

