package com.wayne.porttotask.extensions

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment

fun Fragment.startActivity(uri: Uri) {
    val intent = Intent()
    intent.action = Intent.ACTION_VIEW
    intent.data = uri
    startActivity(intent)
}