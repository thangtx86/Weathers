package io.github.thang86.weathers.adapter

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import io.github.thang86.weathers.R
import io.github.thang86.weathers.domain.model.Address

class NavigationAdapter(
    private val context: Context,
    private val address: List<Address>
) :
    RecyclerView.Adapter<NavigationAdapter.ViewHolder>() {

    private lateinit var mOnItemClickListener: ItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)

        return ViewHolder(inflater.inflate(R.layout.navigation_item, parent, false))
    }

    override fun getItemCount(): Int {
        return address.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val address: Address = address[position]
        holder.bind(address)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var address: TextView = itemView.findViewById(R.id.tv_address)
        private var temperatureIcon: ImageView = itemView.findViewById(R.id.ic_temperature)
        private var temperature: TextView = itemView.findViewById(R.id.tv_temperature)
        private var popupMenu: ImageView = itemView.findViewById(R.id.img_popup_menu)
        private var avartarLocation: ImageView = itemView.findViewById(R.id.avatar_location)

        init {

            itemView.setOnClickListener {
                mOnItemClickListener.onItemClick(adapterPosition)
            }

            popupMenu.setOnClickListener {
                val popup = PopupMenu(popupMenu.context, itemView)
                popup.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.menu_delete -> {
                            Toast.makeText(context, "On Click Delete...", Toast.LENGTH_LONG)
                            true
                        }
                        else -> false
                    }
                }

                popup.inflate(R.menu.options_menu)
                popup.gravity = Gravity.RIGHT
                popup.show()
            }
        }

        fun bind(add: Address) {
            address.text = add.address
            temperature.text = add.temperature
            temperatureIcon.setImageResource(add.icon)
            avartarLocation.setImageResource(add.background)


        }

    }

    fun setItemClickListener(clickListener: ItemClickListener) {
        mOnItemClickListener = clickListener
    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }


}
