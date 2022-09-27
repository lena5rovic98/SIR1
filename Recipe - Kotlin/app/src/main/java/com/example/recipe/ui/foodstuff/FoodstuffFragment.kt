package com.example.recipe.ui.foodstuff

import ViewPagerAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.recipe.Data
import com.example.recipe.R
import com.google.android.material.tabs.TabLayout
import com.example.recipe.models.Foodstuff

class FoodstuffFragment : Fragment(), TabLayout.OnTabSelectedListener {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var nameTextView: TextView
    private lateinit var caloriesValue: EditText
    private lateinit var proteinValue: EditText
    private lateinit var fatsValue: EditText
    private lateinit var sugarValue: EditText
    private lateinit var vitaminAValue: EditText
    private lateinit var vitaminCValue: EditText
    private lateinit var submitButton: Button
    private lateinit var checkBoxDiabetics: CheckBox
    private lateinit var foodstuffRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_foodstuff, container, false)

        tabLayout = root.findViewById(R.id.tabLayout)
        viewPager = root.findViewById(R.id.viewPager)
        submitButton = root.findViewById(R.id.submitButton)
        nameTextView = root.findViewById(R.id.foodstuffName)
        caloriesValue = root.findViewById(R.id.caloriesValue)
        proteinValue = root.findViewById(R.id.proteinValue)
        fatsValue = root.findViewById(R.id.fatsValue)
        sugarValue = root.findViewById(R.id.sugarValue)
        vitaminAValue = root.findViewById(R.id.vitaminAValue)
        vitaminCValue = root.findViewById(R.id.vitaminCValue)
        checkBoxDiabetics = root.findViewById(R.id.isGoodForDiabeticsCheckBox)
        foodstuffRecyclerView = root.findViewById(R.id.foodstuffRecyclerView)

        initData()
        initListeners()

        return root
    }

    @SuppressLint("SetTextI18n")
    private fun initData() {
        viewPager.adapter = ViewPagerAdapter(listOf(R.id.newFoodstuffConstraint, R.id.foodstuffListConstraint))
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                tabLayout.getTabAt(position)?.select()
            }
        })

        val tabTitles = context!!.resources.getStringArray(R.array.foodstuff_tabs)
        for (title in tabTitles) {
            tabLayout.addTab(
                tabLayout.newTab()
                    .setText(title)
                    .setTag(title.lowercase())
            )
        }

        tabLayout.addOnTabSelectedListener(this)

        // Example: var and val
//        val buttonText1 = "Step"
//        var buttonText2 = 1
//        val buttonText1: String = "Step"
//        var buttonText2: Int = 1
//
//        buttonText1 = "Submit"
//        buttonText2 = 2
//
//        buttonText1++
//        buttonText2++
//
//        submitButton.text = buttonText1 + buttonText2

        foodstuffRecyclerView.adapter = FoodstuffAdapter()
        (foodstuffRecyclerView.adapter as FoodstuffAdapter).setFoodstuff(Data.foodstuff)

        checkBoxDiabetics.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // Example: function collection - filter
                val goodForDiabetics = Data.foodstuff.filter {
                    return@filter it.isGoodForDiabetics()
                }.toMutableList()
                (foodstuffRecyclerView.adapter as FoodstuffAdapter).setFoodstuff(goodForDiabetics)
            } else {
                (foodstuffRecyclerView.adapter as FoodstuffAdapter).setFoodstuff(Data.foodstuff)
            }
        })
    }

    private fun initListeners() {
        submitButton.setOnClickListener {
            val name = nameTextView.text.toString()
            val calories = caloriesValue.text.toString().toInt()
            val protein = proteinValue.text.toString().toInt()
            val fats = fatsValue.text.toString().toInt()
            val sugar = sugarValue.text.toString().toInt()
            val vitaminA = vitaminAValue.text.toString().toInt()
            val vitaminC = vitaminCValue.text.toString().toInt()
            val foodstuff = Foodstuff(name, calories, protein, fats, sugar, vitaminA, vitaminC)
            Data.foodstuff.add(foodstuff)
            Toast.makeText(context, R.string.toast_foodstuff_added, Toast.LENGTH_LONG).show()
        }
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        viewPager.currentItem = tab?.position ?: 0
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        Log.d("TAB UNSELECTED", tab?.tag as String)
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        Log.d("TAB RESELECTED", tab?.tag as String)
    }
}
