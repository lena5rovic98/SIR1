package com.example.recipe_java.ui.launcher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recipe_java.Data;
import com.example.recipe_java.R;
import com.example.recipe_java.models.Restaurant;
import org.jetbrains.annotations.NotNull;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private RestaurantClicked listener;

    public RestaurantAdapter(RestaurantClicked listener) {
        this.listener = listener;
    }

    @NonNull
    @NotNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant, parent, false);
        return new RestaurantAdapter.RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RestaurantViewHolder holder, int position) {
        Restaurant restaurant = Data.restaurants.get(position);
        holder.restaurantName.setText(restaurant.getName());
        holder.restaurantAddress.setText(restaurant.getAddress());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            // Example: sealed event
            public void onClick(View view) {
                listener.onRestaurantClicked(restaurant);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Data.restaurants.size();
    }

    class RestaurantViewHolder extends RecyclerView.ViewHolder {

        TextView restaurantName;
        TextView restaurantAddress;

        public RestaurantViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            restaurantName = itemView.findViewById(R.id.restaurantNameText);
            restaurantAddress = itemView.findViewById(R.id.restaurantAddressText);
        }
    }
}
