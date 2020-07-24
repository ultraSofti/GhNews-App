package com.ultrasoft.ghnewsapp.Callback

import android.view.View

interface NewsRecyclerItemClickListener {
    fun onItemClick(view: View, pos:Int)
}