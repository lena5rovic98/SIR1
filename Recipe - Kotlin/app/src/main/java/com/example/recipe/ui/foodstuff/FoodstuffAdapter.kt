package com.example.recipe.ui.foodstuff

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.R
import com.example.recipe.models.Foodstuff

class FoodstuffAdapter: RecyclerView.Adapter<FoodstuffAdapter.FoodstuffViewHolder>() {

    private var foodstuffs: MutableList<Foodstuff> = mutableListOf()

    fun setFoodstuff(foodstuff: MutableList<Foodstuff>) {
        this.foodstuffs = foodstuff
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodstuffViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_foodstuff, parent, false)
        return FoodstuffViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FoodstuffViewHolder, position: Int) {
        val context = holder.itemView.context
        val foodstuff = foodstuffs[position]
        holder.foodstuffName.text = foodstuff.name
        holder.nutriValues.text = "${context.getString(R.string.label_nutri_values)} " +
                "${context.getString(R.string.label_calories)} ${Foodstuff.convertKcalToCal(foodstuff.calories)}kcal, " +
                "${context.getString(R.string.label_protein)} ${foodstuff.protein}g, " +
                "${context.getString(R.string.label_fats)} ${foodstuff.fats}g"
    }

    override fun getItemCount(): Int {
        return foodstuffs.size
    }

    inner class FoodstuffViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var foodstuffName: TextView = itemView.findViewById(R.id.foodstuffNameText)
        var nutriValues: TextView = itemView.findViewById(R.id.nutriValuesText)
    }
}
