package morg.ros.falconapp

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*
import morg.ros.falconapp.R.id.patch
import morg.ros.falconapp.model.ApiClasses
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class MainAdapter constructor(var rocketList: List<ApiClasses.Rocket>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    internal class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder =
            ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_list, p0, false))

    override fun getItemCount(): Int = rocketList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, pos: Int) {
        val actualRocket = rocketList[pos]
        holder.itemView.mission.text = actualRocket.mission_name

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


        Picasso
        .get()
        .load(actualRocket?.links?.mission_patch)
        .placeholder(R.drawable.ic_error)
        .resize(100,100)
        .into(holder.itemView.patch)
    }
}