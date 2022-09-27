package com.example.recipe.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.recipe.Data
import com.example.recipe.R
import com.example.recipe.enums.Level
import com.example.recipe.models.Foodstuff
import com.example.recipe.models.Recipe

class RecipeFragment : Fragment() {

    // Example: lateinit
    private lateinit var recipeName: EditText
    private lateinit var prepTimeValue: EditText
    private lateinit var servesValue: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var description: EditText
    private lateinit var spinner: Spinner
    private lateinit var ingredientsValue: TextView
    private lateinit var submitButton: Button

    private var level: Level? = null

    // Example: by lazy
    private val defaultLevel by lazy { Level.EASY }

    private var ingredients: MutableList<Foodstuff> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_recipe, container, false)

        recipeName = root.findViewById(R.id.recipeName)
        prepTimeValue = root.findViewById(R.id.prepTimeValue)
        servesValue = root.findViewById(R.id.servesValue)
        radioGroup = root.findViewById(R.id.radioGroup)
        description = root.findViewById(R.id.descriptionValue)
        spinner = root.findViewById(R.id.foodstuffDropdown)
        ingredientsValue = root.findViewById(R.id.selectedIngredientsText)
        // Example: comment for lateinit
        submitButton = root.findViewById(R.id.submitButton)

        initData()
        initListeners()

        return root
    }

    private fun initData() {
        val dropDownAdapter: ArrayAdapter<String>? =
            context?.let { context ->
                ArrayAdapter(
                    context,
                    android.R.layout.simple_spinner_dropdown_item,
                    Data.foodstuff.map { it.name }
                )
            }
        spinner.adapter = dropDownAdapter
        spinner.setSelection(0)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>, view: View?,
                position: Int, id: Long
            ) {
                ingredients.add(Data.foodstuff[position])
                // Example: function collection - join to string
                ingredientsValue.text = ingredients.joinToString(
                    separator = ", ",
                    prefix = "Ingredients: "
                ) { it.name }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        level = Level.EASY
        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.easyButton -> {
                    level = Level.EASY
                }
                R.id.mediumButton -> {
                    level = Level.MEDIUM
                }
                R.id.hardButton -> {
                    level = Level.HARD
                }
            }
        })
    }

    private fun initListeners() {
        if (this::submitButton.isInitialized) {
            submitButton.setOnClickListener {
                val name = if (this::recipeName.isInitialized) {
                    recipeName.text.toString()
                } else ""

                val prepTime = prepTimeValue.text.toString().toInt()
                val serves = servesValue.text.toString().toInt()
                val description = description.text.toString()
                val recipeLevel = level ?: defaultLevel
                val levelDescription = level?.getDescription()

                // Example: var and val
                val newRecipe = Recipe(name, description, prepTime, serves, recipeLevel, ingredients)
                // newRecipe.description = "Cook spaghetti and add sauce"
                // newRecipe = Recipe("Spaghetti", "", 50, 4, Level.HARD, null)
                // newRecipe.name = "Spaghetti"

                // val recipeDescription: String = "Cook spaghetti and add sauce"
                // newRecipe.description = recipeDescription
                // newRecipe.description = 1
                // recipeDescription++

                Data.selectedRestaurant?.cookBook?.recipes?.add(newRecipe)

                Toast.makeText(context, R.string.toast_recipe_added, Toast.LENGTH_LONG).show()
            }
        }
    }
}
