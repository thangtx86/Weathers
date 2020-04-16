package io.github.thang86.weathers.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.util.List;

import io.github.thang86.weathers.R;
import io.github.thang86.weathers.data.model.Address;

import static android.view.Gravity.LEFT;
import static android.view.Gravity.RIGHT;

/**
 * ThangTX2
 */
public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.ViewHolder> {

    private ItemClickListener mOnItemClickListener;
    private Context mContext;
    private List<Address> mAddress;

    public NavigationAdapter(Context context, List<Address> addresses) {
        this.mContext = context;
        this.mAddress = addresses;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.navigation_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Address address = mAddress.get(position);
        holder.address.setText(address.getAddress());
        holder.temperature.setText(address.getTemperature());
        holder.avartarLocation.setImageResource(address.getBackground());
        holder.temperatureIcon.setImageResource(address.getIcon());

    }

    @Override
    public int getItemCount() {
        return mAddress.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        private TextView address;
        private ImageView temperatureIcon;
        private TextView temperature;
        private ImageView popupMenu;
        private ImageView avartarLocation;


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(getAdapterPosition());
                }
            });
            address = itemView.findViewById(R.id.tv_address);
            temperatureIcon = itemView.findViewById(R.id.ic_temperature);
            temperature = itemView.findViewById(R.id.tv_temperature);
            avartarLocation = itemView.findViewById(R.id.avatar_location);
            popupMenu = itemView.findViewById(R.id.img_popup_menu);

            popupMenu.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("RestrictedApi")
                @Override
                public void onClick(View v) {
                    PopupMenu popup = new PopupMenu(popupMenu.getContext(), itemView);
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.menu_delete:
                                    Toast.makeText(mContext, "On Click Delete...", Toast.LENGTH_LONG);
                                    return true;
                                default:
                                    return false;
                            }
                        }
                    });

                    popup.inflate(R.menu.options_menu);
                    popup.setGravity(RIGHT);
                    popup.show();


                }
            });
        }
    }

    public void setItemClickListener(ItemClickListener clickListener) {
        mOnItemClickListener = clickListener;
    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }
}