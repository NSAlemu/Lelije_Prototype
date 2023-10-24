package org.lelije.lelijeprototype.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.lelije.lelijeprototype.Models.RideModel;
import org.lelije.lelijeprototype.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ScheduleListAdapter extends RecyclerView.Adapter<ScheduleListAdapter.ViewHolder> {

    private List<RideModel> rideModelList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private boolean isFuture;

    // data is passed into the constructor
    public ScheduleListAdapter(Context context, List<RideModel> rideModelList, boolean isFuture) {
        this.mInflater = LayoutInflater.from(context);
        this.rideModelList = rideModelList;
        this.isFuture = isFuture;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.card_schedule_list, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RideModel ride = rideModelList.get(position);
        StringBuilder names = new StringBuilder();
        for (int i = 0; i < ride.getParent().getChildren().size(); i++) {
            names.append(ride.getParent().getChildren().get(i).getFirstName());
            if (i + 2 < ride.getParent().getChildren().size()) {
                names.append(", ");
            }
            if (i + 2 == ride.getParent().getChildren().size()) {
                names.append(", and ");
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.US);
        if (isFuture) {
            holder.title.setText(names.append(" have an upcoming ride"));
            holder.time.setText(sdf.format(ride.scheduledPickupTime));
        } else {
            holder.title.setText(names.append(" completed a ride"));
            holder.time.setText(sdf.format(ride.scheduledDropoffTime));
        }
        sdf = new SimpleDateFormat("EEE MMM d, yyyy", Locale.US);
        holder.date.setText(sdf.format(ride.scheduledPickupTime));
        holder.pickup.setText(ride.getScheduledPickupLocation());
        holder.dropoff.setText(ride.getScheduledDropoffLocation());
        if (position == 0) {
            holder.dateContainer.setVisibility(View.VISIBLE);
        } else {
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(rideModelList.get(position).getScheduledPickupTime());
            cal2.setTime(rideModelList.get(position - 1).getScheduledPickupTime());
            boolean isSameDay = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                    cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
            if (isSameDay)
                holder.dateContainer.getLayoutParams().height =2;
            else
                holder.dateContainer.setVisibility(View.VISIBLE);
        }

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return rideModelList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, time, pickup, dropoff, date;
        LinearLayout dateContainer;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.card_schedule_list_title);
            time = itemView.findViewById(R.id.card_schedule_list_time);
            pickup = itemView.findViewById(R.id.card_schedule_list_pickup);
            dropoff = itemView.findViewById(R.id.card_schedule_list_dropoff);
            date = itemView.findViewById(R.id.card_schedule_list_date);
            dateContainer = itemView.findViewById(R.id.card_schedule_list_date_container);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}