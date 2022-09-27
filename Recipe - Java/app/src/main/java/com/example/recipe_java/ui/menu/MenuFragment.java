package com.example.recipe_java.ui.menu;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recipe_java.Data;
import com.example.recipe_java.R;
import com.example.recipe_java.models.Recipe;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MenuFragment extends Fragment {

    private CheckBox checkBoxDiabetics;
    private CheckBox sortByPrepTime;
    private EditText searchEditText;
    private TextView recipeCountText;
    private RecyclerView recipesRecyclerView;
    private RecipeAdapter recipeAdapter;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        checkBoxDiabetics = view.findViewById(R.id.isGoodForDiabetics);
        sortByPrepTime = view.findViewById(R.id.sortByPrepTime);
        searchEditText = view.findViewById(R.id.searchEditText);
        recipeCountText = view.findViewById(R.id.recipeCountText);
        recipesRecyclerView = view.findViewById(R.id.recipesRecyclerView);

        initData();
        initListeners();
    }

    private void initData() {
        recipesRecyclerView.setAdapter(new RecipeAdapter());
        recipeAdapter = (RecipeAdapter) recipesRecyclerView.getAdapter();
        recipeAdapter.setRecipes(Data.cookBook.getRecipes());
        recipeCountText.setText(getContext().getString(R.string.label_recipe_count) + Data.cookBook.getRecipes().size());
    }

    private void initListeners() {
        checkBoxDiabetics.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBoxDiabetics.isChecked()) {
                    long startTime = System.currentTimeMillis();
                    List<Recipe> goodForDiabetics = Data.cookBook.getRecipes().stream().filter(
                            Recipe::isAcceptableForDiabetes
                    ).collect(Collectors.toList());
                    long endTime = System.currentTimeMillis();
                    long time = endTime - startTime;
                    recipeAdapter.setRecipes((ArrayList<Recipe>) goodForDiabetics);
                    recipeCountText.setText(getContext().getString(R.string.label_recipe_count) + goodForDiabetics.size());
                } else {
                    recipeAdapter.setRecipes(Data.cookBook.getRecipes());
                    recipeCountText.setText(getContext().getString(R.string.label_recipe_count) + Data.cookBook.getRecipes().size());
                }
            }
        });

        sortByPrepTime.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (sortByPrepTime.isChecked()) {
                    // Example: function collection - sort
                    List<Recipe> sortedRecipesByPrepTime = Data.cookBook.getRecipes().stream().sorted(
                            Comparator.comparing(Recipe::getPreparationTime)
                    ).collect(Collectors.toList());
                    recipeAdapter.setRecipes(sortedRecipesByPrepTime);
                    recipeCountText.setText(getContext().getString(R.string.label_recipe_count) + sortedRecipesByPrepTime.size());
                } else {
                    recipeAdapter.setRecipes(Data.cookBook.getRecipes());
                    recipeCountText.setText(getContext().getString(R.string.label_recipe_count) + Data.cookBook.getRecipes().size());
                }
            }
        });

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Example: function collection - find
                List<Recipe> searchedRecipes = Data.cookBook.getRecipes().stream().filter(
                        recipe -> recipe.getName().contains(charSequence)
                ).collect(Collectors.toList());

                if (!searchedRecipes.isEmpty()) {
                    recipeAdapter.setRecipes(searchedRecipes);
                    recipeCountText.setText(getContext().getString(R.string.label_recipe_count + searchedRecipes.size()));
                } else {
                    recipeAdapter.setRecipes(new ArrayList<>());
                    // Example: ternary operator
                    recipeCountText.setText((Data.cookBook.getRecipes() != null) ? Data.cookBook.getRecipes().size() : 0);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });
    }
}
