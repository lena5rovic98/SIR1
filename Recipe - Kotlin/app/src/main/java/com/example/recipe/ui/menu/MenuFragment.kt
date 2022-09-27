package com.example.recipe.ui.menu

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.Data
import com.example.recipe.R
import java.time.LocalDateTime
import kotlin.system.measureTimeMillis

class MenuFragment : Fragment() {

    private lateinit var checkBoxDiabetics: CheckBox
    private lateinit var sortByPrepTime: CheckBox
    private lateinit var searchEditText: EditText
    private lateinit var recipeCountText: TextView
    private lateinit var recipesRecyclerView: RecyclerView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_menu, container, false)

        recipesRecyclerView = root.findViewById(R.id.recipesRecyclerView)
        recipeCountText = root.findViewById(R.id.recipeCountText)
        sortByPrepTime = root.findViewById(R.id.sortByPrepTime)
        checkBoxDiabetics = root.findViewById(R.id.isGoodForDiabetics)
        searchEditText = root.findViewById(R.id.searchEditText)

        initData()
        initListeners()

        return root
    }

    private fun initData() {
        recipesRecyclerView.adapter = RecipeAdapter()
        Data.cookBook.recipes?.let { (recipesRecyclerView.adapter as RecipeAdapter).setRecipes(it) }
        recipeCountText.text = "${context?.getString(R.string.label_recipe_count)} ${Data.cookBook.recipes?.size ?: 0}"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    private fun initListeners() {
        checkBoxDiabetics.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
//                val time = measureTimeMillis {
//                    val goodForDiabetics = Data.cookBook.recipes?.filter {
//                        return@filter it.isAcceptableForDiabetes()
//                    }?.toMutableList()
//                }

                val goodForDiabetics = Data.cookBook.recipes?.filter {
                    return@filter it.isAcceptableForDiabetes()
                }?.toMutableList()

                if (goodForDiabetics != null) {
                    (recipesRecyclerView.adapter as RecipeAdapter).setRecipes(goodForDiabetics)
                }
                recipeCountText.text = "${context?.getString(R.string.label_recipe_count)} ${goodForDiabetics?.size ?: 0}"

            } else {
                Data.cookBook.recipes?.let { (recipesRecyclerView.adapter as RecipeAdapter).setRecipes(it) }
                // Example: elvis operator
                recipeCountText.text = "${context?.getString(R.string.label_recipe_count)} ${Data.cookBook.recipes?.size ?: 0}"
            }
        })

        sortByPrepTime.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // Example: function collection - sort
//                val sortedRecipesByPrepTime = Data.cookBook.recipes?.sortedByDescending {
//                    it.preparationTime
//                }
                val sortedRecipesByPrepTime = Data.cookBook.recipes?.sortedBy {
                    it.preparationTime
                }
                if (sortedRecipesByPrepTime != null) {
                    (recipesRecyclerView.adapter as RecipeAdapter).setRecipes(sortedRecipesByPrepTime)
                    recipeCountText.text = "${context?.getString(R.string.label_recipe_count)} ${sortedRecipesByPrepTime.size}"
                }
            } else {
                Data.cookBook.recipes?.let { (recipesRecyclerView.adapter as RecipeAdapter).setRecipes(it) }
                recipeCountText.text = "${context?.getString(R.string.label_recipe_count)} ${Data.cookBook.recipes?.size ?: 0}"
            }
        })

        searchEditText.addTextChangedListener {
            // Example: function collection - find
            val searchedRecipes = Data.cookBook.recipes?.find {
                return@find it.name.contains(searchEditText.text)
            }
            if (searchedRecipes != null) {
                (recipesRecyclerView.adapter as RecipeAdapter).setRecipes(listOf(searchedRecipes))
            } else {
                (recipesRecyclerView.adapter as RecipeAdapter).setRecipes(listOf())

                recipeCountText.text = "${context?.getString(R.string.label_recipe_count)} ${Data.cookBook.recipes?.size ?: 0}"
            }
        }
    }
}
