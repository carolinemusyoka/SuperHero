package com.carol.musyoka.superhero.ui.main

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class DefaultItemDecorator (private val horizontalSpacing: Int,
 private val verticalSpacing: Int): RecyclerView.ItemDecoration(){
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.right = horizontalSpacing
        outRect.left = horizontalSpacing
        if (parent.getChildLayoutPosition(view)==0){
            outRect.top = verticalSpacing
        }
        outRect.bottom = verticalSpacing
    }
}