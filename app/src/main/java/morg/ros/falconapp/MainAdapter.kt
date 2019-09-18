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

class MainAdapter constructor(var rocketList: List<ApiClasses.Rocket>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    internal class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder =
            ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_list, p0, false))

    override fun getItemCount(): Int = rocketList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, pos: Int) {
        val actualRocket = rocketList[pos]
        holder.itemView.mission.text = actualRocket.mission_name
        holder.itemView.date.text = actualRocket.launch_date_utc
        holder.itemView.success.text = actualRocket.launch_success.toString()

        Picasso
                .get()
                .load(actualRocket?.links?.mission_patch)
                .placeholder(R.drawable.ic_error)
                .into(holder.itemView.patch)
    }
}