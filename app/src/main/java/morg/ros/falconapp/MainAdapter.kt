package morg.ros.falconapp

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*
import morg.ros.falconapp.model.ApiClasses
import java.text.SimpleDateFormat
import java.util.*
import android.app.Activity



class MainAdapter constructor(var rocketList: List<ApiClasses.Rocket>) :
        androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    internal class ViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder =
            ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_list, p0, false))

    override fun getItemCount(): Int = rocketList.size

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, pos: Int) {
        val actualRocket = rocketList[pos]
        holder.itemView.mission.text = actualRocket.mission_name

        // display status image
        if(actualRocket.launch_success)
            holder.itemView.imageSuccess.setImageResource(R.drawable.mission_ok)
        else
            holder.itemView.imageSuccess.setImageResource(R.drawable.mission_failed)

        // format data
        val sdf = java.text.SimpleDateFormat("yyyy-MM-dd")
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        formatter.timeZone = TimeZone.getTimeZone("UTC")
        val result = formatter.parse(actualRocket.launch_date_utc)
        holder.itemView.date.text = sdf.format(result)

        // display mission patch
        Picasso.get()
                .load(actualRocket?.links?.mission_patch)
                .placeholder(R.drawable.ic_star_black_24dp)
                .error(R.drawable.ic_error)
                .fit()
                .centerCrop()
                .into(holder.itemView.patch)

    }
}