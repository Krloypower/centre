package rubbish.builder;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-06-17 11:28
 **/
public class Main {
    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();
        Meal meal = builder.prepareNonMeal();
        System.out.println(" non ");
        meal.show();
        System.out.println("cost :" + meal.cost());

        System.out.println("Vel");

        Meal meal1 = builder.prepareVelMeal();
        meal1.show();
        System.out.println("cost :" + meal1.cost());
    }
}
