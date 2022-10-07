package com.example.recipe_java.ui.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recipe_java.R;
import com.example.recipe_java.enums.Level;
import com.example.recipe_java.models.Recipe;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Recipe> recipes = new ArrayList<>();

    public void setRecipes(List<Recipe> recipes) {
        for (Recipe recipe: recipes) {
            if (this.recipes.size() % 3 == 0 && this.recipes.size() != 0) {
                this.recipes.add(new Recipe("Reklama", "", 0, 0, Level.EASY, null));
            }
            this.recipes.add(recipe);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0 && position != 0) {
            return 0;
        } else return 1;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ad, parent, false);
            return new RecipeAdapter.AdViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
            return new RecipeAdapter.RecipeViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        Recipe recipe = recipes.get(position);
        // Example: smart cast
        if (holder instanceof RecipeViewHolder) {
            ((RecipeViewHolder) holder).recipeName.setText(recipe.name);
            ((RecipeViewHolder) holder).recipeDescription.setText(recipe.getDescription());
            ((RecipeViewHolder) holder).recipePrepTime.setText(context.getString(R.string.label_prep_time) + recipe.getPreparationTime() + "mins");
            ((RecipeViewHolder) holder).recipeServes.setText(context.getString(R.string.label_serves) + recipe.getServes());
            ((RecipeViewHolder) holder).recipeLevel.setText(recipe.getLevel().getDescription(recipe.getLevel()));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String description = "Opis: ${if (recipe.description!!.isEmpty()) \"Nema opisa\" else recipe.description }, i za ${recipe.serves} osoba";
                    String prepTime = "Vreme pripreme: ${recipe.preparationTime.getStyledPreparationTime()}";
                    String serves = "Broj porcija: ${recipe.serves * 2 / 2} ";

                    Toast.makeText(context, description + "\n" + prepTime + "\n" + serves, Toast.LENGTH_LONG).show();
                }
            });
        }
        else if (holder instanceof AdViewHolder) {

        }
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder {

        TextView recipeName;
        TextView recipeDescription;
        TextView recipePrepTime;
        TextView recipeServes;
        TextView recipeLevel;

        public RecipeViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.recipeNameText);
            recipeDescription = itemView.findViewById(R.id.recipeDescriptionText);
            recipePrepTime = itemView.findViewById(R.id.recipePrepTimeText);
            recipeServes = itemView.findViewById(R.id.recipeServesText);
            recipeLevel = itemView.findViewById(R.id.recipeLevelText);
        }
    }

    class AdViewHolder extends RecyclerView.ViewHolder {

        ImageView adImage;

        public AdViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            adImage = itemView.findViewById(R.id.adImage);
        }
    }
}
