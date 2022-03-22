package com.wildforkfoods.food.widgets

import android.graphics.Rect
import android.view.View
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class SpacesItemDecoration(left: Int, right: Int, top: Int, bottom: Int) : RecyclerView.ItemDecoration() {
    private var right: Int = 0
    private var top: Int = 0
    private var bottom: Int = 0
    private var left: Int = 0
    init {
        this.left = left
        this.right = right
        this.top = top
        this.bottom = bottom
    }
    override fun getItemOffsets(@NonNull outRect: Rect, @NonNull view: View, @NonNull parent: RecyclerView, @NonNull state: RecyclerView.State) {
        outRect.left = left
        outRect.right = right
        outRect.bottom = bottom
        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildLayoutPosition(view) === 0 || parent.getChildLayoutPosition(view) === 1) {
            outRect.top = top
        } else {
            outRect.top = 0
        }
    }
}
