package com.example.recipe_java.ui.recipe;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import com.example.recipe_java.Data;
import com.example.recipe_java.R;
import com.example.recipe_java.enums.Level;
import com.example.recipe_java.models.Foodstuff;
import com.example.recipe_java.models.Recipe;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class RecipeFragment extends Fragment {

    private EditText recipeName;
    private EditText prepTimeValue;
    private EditText servesValue;
    private RadioGroup radioGroup;
    private EditText description;
    private Spinner spinner;
    private TextView ingredientsValue;
    private Button submitButton;
    private Level level;

    private ArrayList<Foodstuff> ingredients = new ArrayList<>();

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recipe, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recipeName = view.findViewById(R.id.recipeName);
        prepTimeValue = view.findViewById(R.id.prepTimeValue);
        servesValue = view.findViewById(R.id.servesValue);
        radioGroup = view.findViewById(R.id.radioGroup);
        description = view.findViewById(R.id.descriptionValue);
        spinner = view.findViewById(R.id.foodstuffDropdown);
        ingredientsValue = view.findViewById(R.id.selectedIngredientsText);
        submitButton = view.findViewById(R.id.submitButton);

        initData();
        initListeners();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initData() {
        ArrayAdapter<String> dropDownAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, Data.foodstuff.stream().map(Foodstuff::getName).collect(Collectors.toList()));

        spinner.setAdapter(dropDownAdapter);
        spinner.setSelection(0);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                ingredients.add(Data.foodstuff.get(position));
                // Example: function collection - join to string
                ingredientsValue.setText(ingredients.stream().map(
                        Foodstuff::getName
                ).collect(Collectors.joining(
                        ", ",
                        "Ingredients: ",
                        ".")
                ));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        level = Level.EASY;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.easyButton: {
                        level = Level.EASY;
                        break;
                    }
                    case R.id.mediumButton: {
                        level = Level.MEDIUM;
                        break;
                    }
                    case R.id.hardButton: {
                        level = Level.HARD;
                        break;
                    }
                }
            }
        });
    }

    private void initListeners() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = recipeName.getText().toString();
                Integer prepTime = Integer.parseInt(prepTimeValue.getText().toString());
                Integer serves = Integer.parseInt(servesValue.getText().toString());
                String desc = description.getText().toString();
                Level recipeLevel = level;
                String levelDescription = level.getDescription(level);

                // Example: final
                // final Recipe newRecipe = new Recipe(name, desc, prepTime, serves, recipeLevel, ingredients);

                Recipe newRecipe = new Recipe(name, desc, prepTime, serves, recipeLevel, ingredients);
                newRecipe = new Recipe("Spaghetti", "", 50, 4, Level.HARD, null);
                // newRecipe.setDescription("New description");

                Data.selectedRestaurant.getCookBook().addRecipe(newRecipe);
                Toast.makeText(getContext(), R.string.toast_recipe_added, Toast.LENGTH_LONG).show();
            }
        });
    }
}
