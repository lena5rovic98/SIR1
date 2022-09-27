package com.example.recipe_java.ui.launcher;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recipe_java.Data;
import com.example.recipe_java.MainActivity;
import com.example.recipe_java.R;
import com.example.recipe_java.models.Restaurant;

public class LauncherActivity extends AppCompatActivity implements RestaurantClicked {

    RecyclerView restaurantsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        restaurantsRecyclerView = findViewById(R.id.restaurantsRecyclerView);

        initData();
    }

    private void initData() {
        Data.init();

        // Example: sealed event
        restaurantsRecyclerView.setAdapter(new RestaurantAdapter(this));
    }

    // Example: sealed event
    @Override
    public void onRestaurantClicked(Restaurant restaurant) {
        Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
        Data.selectedRestaurant = restaurant;
        startActivity(intent);
    }
}

// Example: sealed event
interface RestaurantClicked {
    void onRestaurantClicked(Restaurant restaurant);
}
