// Step 1: MealPlan Interface
interface MealPlan {
    String getMealCategory();
    String getMealDescription();
}

// Step 2: Subtypes of MealPlan Interface (e.g., Vegetarian, Vegan, Keto, HighProtein)
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealCategory() {
        return "Vegetarian";
    }

    @Override
    public String getMealDescription() {
        return "A meal plan with plant-based food, excluding meat and fish.";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealCategory() {
        return "Vegan";
    }

    @Override
    public String getMealDescription() {
        return "A meal plan that excludes all animal products, including dairy and eggs.";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealCategory() {
        return "Keto";
    }

    @Override
    public String getMealDescription() {
        return "A low-carb, high-fat meal plan designed to induce ketosis.";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealCategory() {
        return "High-Protein";
    }

    @Override
    public String getMealDescription() {
        return "A meal plan focused on high-protein foods to promote muscle growth and recovery.";
    }
}

// Step 3: Generic Meal<T> Class to Handle Different Meal Plans
class Meal<T extends MealPlan> {
    private T mealPlan;
    private String mealName;

    public Meal(String mealName, T mealPlan) {
        this.mealName = mealName;
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public String getMealName() {
        return mealName;
    }

    @Override
    public String toString() {
        return mealName + " (" + mealPlan.getMealCategory() + "): " + mealPlan.getMealDescription();
    }
}

// Step 4: MealPlan Generator with Validation Method
class MealPlanGenerator {

    // Generic method to validate and generate a personalized meal plan
    public <T extends MealPlan> void generateMealPlan(T mealPlan) {
        if (mealPlan != null) {
            System.out.println("Generating a personalized meal plan: ");
            System.out.println("Category: " + mealPlan.getMealCategory());
            System.out.println("Description: " + mealPlan.getMealDescription());
        } else {
            System.out.println("Invalid meal plan! Please choose a valid plan.");
        }
    }
}

// Step 5: Main Class to Test the Implementation
public class PersonalizedMealPlanGenerator {

    public static void main(String[] args) {
        // Creating instances of different meal plans
        Meal<VegetarianMeal> vegetarianMeal = new Meal<>("Veggie Delight", new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>("Vegan Feast", new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>("Keto Power", new KetoMeal());
        Meal<HighProteinMeal> highProteinMeal = new Meal<>("Protein Boost", new HighProteinMeal());

        // Creating a MealPlanGenerator instance
        MealPlanGenerator mealPlanGenerator = new MealPlanGenerator();

        // Generating personalized meal plans
        mealPlanGenerator.generateMealPlan(vegetarianMeal.getMealPlan());
        mealPlanGenerator.generateMealPlan(veganMeal.getMealPlan());
        mealPlanGenerator.generateMealPlan(ketoMeal.getMealPlan());
        mealPlanGenerator.generateMealPlan(highProteinMeal.getMealPlan());
    }
}
