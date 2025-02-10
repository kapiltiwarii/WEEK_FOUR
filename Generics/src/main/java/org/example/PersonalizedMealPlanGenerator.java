package org.example;

import java.util.ArrayList;
import java.util.List;

// MealPlan Interface (Base Type)
interface MealPlan {
    String getMealName();
    int getCalories();
    void displayMealDetails();
}

// Vegetarian Meal
class VegetarianMeal implements MealPlan {
    private String mealName;
    private int calories;

    public VegetarianMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public void displayMealDetails() {
        System.out.println("Vegetarian Meal: " + mealName + ", Calories: " + calories);
    }
}

// Vegan Meal
class VeganMeal implements MealPlan {
    private String mealName;
    private int calories;

    public VeganMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public void displayMealDetails() {
        System.out.println("Vegan Meal: " + mealName + ", Calories: " + calories);
    }
}

// Keto Meal
class KetoMeal implements MealPlan {
    private String mealName;
    private int calories;

    public KetoMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public void displayMealDetails() {
        System.out.println("Keto Meal: " + mealName + ", Calories: " + calories);
    }
}

// High Protein Meal
class HighProteinMeal implements MealPlan {
    private String mealName;
    private int calories;

    public HighProteinMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public void displayMealDetails() {
        System.out.println("High Protein Meal: " + mealName + ", Calories: " + calories);
    }
}

// Generic Meal Class
class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public T getMeal() {
        return meal;
    }

    public void displayMeal() {
        meal.displayMealDetails();
    }
}

// Meal Planner Class with a Generic Method
class MealPlanner {
    private List<MealPlan> mealPlans = new ArrayList<>();

    public <T extends MealPlan> void addMealPlan(Meal<T> meal) {
        mealPlans.add(meal.getMeal());
    }

    public void displayMealPlans() {
        System.out.println("\nPersonalized Meal Plans:");
        for (MealPlan meal : mealPlans) {
            meal.displayMealDetails();
        }
    }

    // Wildcard Method to Display All Meals
    public static void displayAllMeals(List<? extends MealPlan> meals) {
        System.out.println("\nAll Available Meals:");
        for (MealPlan meal : meals) {
            meal.displayMealDetails();
        }
    }
}

// Main Class for Execution
public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        // Creating Meal Planner
        MealPlanner mealPlanner = new MealPlanner();

        // Creating Meals
        VegetarianMeal vegMeal = new VegetarianMeal("Vegetable Stir Fry", 400);
        VeganMeal veganMeal = new VeganMeal("Tofu Salad", 350);
        KetoMeal ketoMeal = new KetoMeal("Grilled Chicken & Avocado", 600);
        HighProteinMeal proteinMeal = new HighProteinMeal("Salmon with Quinoa", 550);

        // Wrapping Meals in Generic Meal Class
        Meal<VegetarianMeal> vegMealWrapped = new Meal<>(vegMeal);
        Meal<VeganMeal> veganMealWrapped = new Meal<>(veganMeal);
        Meal<KetoMeal> ketoMealWrapped = new Meal<>(ketoMeal);
        Meal<HighProteinMeal> proteinMealWrapped = new Meal<>(proteinMeal);

        // Adding Meals to the Meal Planner
        mealPlanner.addMealPlan(vegMealWrapped);
        mealPlanner.addMealPlan(veganMealWrapped);
        mealPlanner.addMealPlan(ketoMealWrapped);
        mealPlanner.addMealPlan(proteinMealWrapped);

        // Displaying Personalized Meal Plans
        mealPlanner.displayMealPlans();

        // Wildcard Method to Display All Meals without List.of()
        List<MealPlan> allMeals = new ArrayList<>();
        allMeals.add(vegMeal);
        allMeals.add(veganMeal);
        allMeals.add(ketoMeal);
        allMeals.add(proteinMeal);

        MealPlanner.displayAllMeals(allMeals);
    }
}
