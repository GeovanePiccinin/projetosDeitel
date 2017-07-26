public class BuilderPatternDemo 
{
	public static void main(String[] args)
	{
		MealBuilder mealBuilder = new MealBuilder();

		Meal vegMeal = mealBuilder.prepareVegMeal();
		vegMeal.showItems();
		vegMeal.getCost();

		Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
		nonVegMeal.showItems();
		nonVegMeal.getCost();
		
	}
}
