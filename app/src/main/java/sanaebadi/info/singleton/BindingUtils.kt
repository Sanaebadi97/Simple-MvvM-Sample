package sanaebadi.info.singleton

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions().optionalCircleCrop()
                    .placeholder(R.drawable.ic_sync_problem_black_24dp)
                    .error(R.drawable.ic_broken_image_black_24dp)
            )
            .into(imgView)
    }
}