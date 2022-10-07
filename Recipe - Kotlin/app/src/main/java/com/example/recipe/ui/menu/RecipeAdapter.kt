package com.example.recipe.ui.menu

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.R
import com.example.recipe.enums.Level
import com.example.recipe.extensions.getStyledPreparationTime
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.recipe.models.Recipe

class RecipeAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var recipes: ArrayList<Recipe> = arrayListOf()

    fun setRecipes(recipes: List<Recipe>) {
        this.recipes.clear()
        for (recipe in recipes) {
            if (this.recipes.size % 3 == 0 && this.recipes.size != 0) {
                this.recipes.add(Recipe("Reklama", null, 0, 0, Level.EASY, null))
            }
            this.recipes.add(recipe)
        }
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 3 == 0 && position != 0) {
            0
        } else 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_ad, parent, false)
            AdViewHolder(view)
        } else {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
            RecipeViewHolder(view)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val context = holder.itemView.context
        val recipe = recipes[position]
        // Example: smart cast
        if (holder is RecipeViewHolder) {
            (holder as RecipeViewHolder).recipeName.text = recipe.name
            holder.recipeDescription.text = recipe.description ?: "Bez opisa"
            holder.recipePrepTime.text = "${context.getString(R.string.label_prep_time)} ${recipe.preparationTime}min"
            holder.recipeServes.text = "${context.getString(R.string.label_serves)} ${recipe.serves}"

            // Example: null safety
            holder.recipeLevel.text = recipe.level.getDescription()!!

            holder.itemView.setOnClickListener {
                // Example: null safety - safe call
                // Example: string template
                val description = "Description is: ${if (recipe.description?.isEmpty() == true) "Bez opisa" else recipe.description }, and it is for ${recipe.serves} people"
                // Example: extension function
                val prepTime = "Prep time: ${recipe.preparationTime.getStyledPreparationTime()}"
                val serves = "Serves: ${recipe.serves * 2 / 2} "

                Toast.makeText(context, "$description\n$prepTime\n$serves", Toast.LENGTH_LONG).show()
            }
        } else if (holder is AdViewHolder) {
            // Example: Coroutines
            GlobalScope.launch {
                delay(2000)
                holder.adText.text = "Reklama Reklama Reklama Reklama"
            }
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    inner class RecipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var recipeName: TextView = itemView.findViewById(R.id.recipeNameText)
        var recipeDescription: TextView = itemView.findViewById(R.id.recipeDescriptionText)
        var recipePrepTime: TextView = itemView.findViewById(R.id.recipePrepTimeText)
        var recipeServes: TextView = itemView.findViewById(R.id.recipeServesText)
        var recipeLevel: TextView = itemView.findViewById(R.id.recipeLevelText)
    }

    inner class AdViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var adImage: ImageView = itemView.findViewById(R.id.adImage)
        var adText: TextView = itemView.findViewById(R.id.adText)
    }
}
