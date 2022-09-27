package com.example.recipe_java.ui.foodstuff;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recipe_java.R;
import com.example.recipe_java.models.Foodstuff;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class FoodstuffAdapter extends RecyclerView.Adapter<FoodstuffAdapter.FoodstuffViewHolder> {

    private ArrayList<Foodstuff> foodstuffs;

    public void setFoodstuff(ArrayList<Foodstuff> foodstuffs) {
        this.foodstuffs = foodstuffs;

        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public FoodstuffViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foodstuff, parent, false);
        return new FoodstuffViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return foodstuffs.size();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull FoodstuffViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        Foodstuff foodstuff = foodstuffs.get(position);
        holder.foodstuffName.setText(foodstuff.getName());
        holder.nutriValues.setText(context.getString(R.string.label_nutri_values) +
                context.getString(R.string.label_calories) + Foodstuff.convertKcalToCal(foodstuff.getCalories()) + "kcal, " +
                context.getString(R.string.label_protein) + foodstuff.getProtein()  + "g, " +
                context.getString(R.string.label_fats) + foodstuff.getFats() + "g, ");
    }

    class FoodstuffViewHolder extends RecyclerView.ViewHolder {

        TextView foodstuffName;
        TextView nutriValues;

        public FoodstuffViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            foodstuffName = itemView.findViewById(R.id.foodstuffNameText);
            nutriValues = itemView.findViewById(R.id.nutriValuesText);
        }
    }
}
