package com.example.recipe_java.ui.foodstuff;

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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.example.recipe_java.Data;
import com.example.recipe_java.R;
import com.example.recipe_java.common.ViewPagerAdapter;
import com.example.recipe_java.models.Foodstuff;
import com.google.android.material.tabs.TabLayout;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FoodstuffFragment extends Fragment implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView nameTextView;
    private EditText caloriesValue;
    private EditText proteinValue;
    private EditText fatsValue;
    private EditText sugarValue;
    private EditText vitaminAValue;
    private EditText vitaminCValue;
    private Button submitButton;
    private CheckBox checkBoxDiabetics;
    private RecyclerView foodstuffRecyclerView;
    private FoodstuffAdapter foodstuffAdapter;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_foodstuff, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);
        submitButton = view.findViewById(R.id.submitButton);
        nameTextView = view.findViewById(R.id.foodstuffName);
        caloriesValue = view.findViewById(R.id.caloriesValue);
        proteinValue = view.findViewById(R.id.proteinValue);
        fatsValue = view.findViewById(R.id.fatsValue);
        sugarValue = view.findViewById(R.id.sugarValue);
        vitaminAValue = view.findViewById(R.id.vitaminAValue);
        vitaminCValue = view.findViewById(R.id.vitaminCValue);
        checkBoxDiabetics = view.findViewById(R.id.isGoodForDiabeticsCheckBox);
        foodstuffRecyclerView = view.findViewById(R.id.foodstuffRecyclerView);

        initData();
        initListeners();
    }

    public void initData() {
        int[] layouts = new int[]{R.id.newFoodstuffConstraint, R.id.foodstuffListConstraint};
        viewPager.setAdapter(new ViewPagerAdapter(getContext(), layouts));

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        List<String> tabTitles = Arrays.asList(getContext().getResources().getStringArray(R.array.foodstuff_tabs));
        for (String title: tabTitles) {
            tabLayout.addTab(
                    tabLayout.newTab()
                            .setText(title)
                            .setTag(title.toLowerCase())
            );
        }

        tabLayout.addOnTabSelectedListener(this);

        foodstuffRecyclerView.setAdapter(new FoodstuffAdapter());
        foodstuffAdapter = (FoodstuffAdapter) foodstuffRecyclerView.getAdapter();
        foodstuffAdapter.setFoodstuff(Data.foodstuff);
    }

    private void initListeners() {
        checkBoxDiabetics.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBoxDiabetics.isChecked()) {
                    // Example: function collection - filter
                    List<Foodstuff> goodForDiabetics = Data.foodstuff.stream().filter(
                            Foodstuff::isGoodForDiabetics
                    ).collect(Collectors.toList());
                    foodstuffAdapter.setFoodstuff((ArrayList<Foodstuff>) goodForDiabetics);
                } else {
                    foodstuffAdapter.setFoodstuff(Data.foodstuff);
                }
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameTextView.getText().toString();
                Integer calories = Integer.parseInt(caloriesValue.getText().toString());
                Integer protein = Integer.parseInt(proteinValue.getText().toString());
                Integer fats = Integer.parseInt(fatsValue.getText().toString());
                Integer sugar = Integer.parseInt(sugarValue.getText().toString());
                Integer vitaminA = Integer.parseInt(vitaminAValue.getText().toString());
                Integer vitaminC = Integer.parseInt(vitaminCValue.getText().toString());
                Foodstuff foodstuff = new Foodstuff(name, calories, protein, fats, sugar, vitaminA, vitaminC);
                Data.foodstuff.add(foodstuff);
                Toast.makeText(getContext(), R.string.toast_foodstuff_added, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) { }

    @Override
    public void onTabReselected(TabLayout.Tab tab) { }
}
