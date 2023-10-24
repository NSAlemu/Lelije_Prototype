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

public class CurrentRideListAdapter extends RecyclerView.Adapter<CurrentRideListAdapter.ViewHolder> {

    private List<RideModel> rideModelList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public CurrentRideListAdapter(Context context, List<RideModel> rideModelList) {
        this.mInflater = LayoutInflater.from(context);
        this.rideModelList = rideModelList;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.card_current_ride_popup, parent, false);
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

        holder.title.setText(names);
        holder.eta.setText(sdf.format(ride.scheduledDropoffTime));

        sdf = new SimpleDateFormat("EEE MMM d, yyyy", Locale.US);
        holder.stops.setText("4 Stops Away");
        holder.location.setText(ride.getScheduledDropoffLocation());
        holder.dateContainer.getLayoutParams().height =2;

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return rideModelList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, eta, location, stops;
        LinearLayout dateContainer;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.card_current_ride_popup_title);
            eta = itemView.findViewById(R.id.card_current_ride_popup_eta);
            location = itemView.findViewById(R.id.card_current_ride_popup_location);
            stops = itemView.findViewById(R.id.card_current_ride_popup_stops);
            dateContainer = itemView.findViewById(R.id.card_current_ride_popup_date_container);
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