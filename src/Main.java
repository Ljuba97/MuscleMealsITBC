import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Food eggs = new Food("Eggs", 155, 13, 1, 11, 0);
        Food spinach = new Food("Spinach", 23, 2.2, 1.3, 0.6, 2.2);
        Food bacon = new Food("Bacon", 540, 37, 1.4, 42, 0);
        Food cheese = new Food("Cheese", 400, 25, 1.3, 33, 0);
        Food bread = new Food("Bread", 265, 9, 49, 3.2, 2.7);
        Food noodles = new Food("Noodles", 138, 4.5, 25, 2.1, 1.2);

        Drink tomatoJuice = new Drink("Tomato_Juice", 17, 0.8, 4.2, 0.1, 0.4);
        Drink water = new Drink("Water", 0, 0, 0, 0, 0);

        Fridge fridge = new Fridge();
        fridge.add(new Food(eggs), 300);
        fridge.add(new Food(spinach), 200);
        fridge.add(new Food(bacon), 50);
        fridge.add(new Food(bread), 50);


        ArrayList<Nutriment> nutriments = new ArrayList<>();
        nutriments.add(eggs);
        nutriments.add(spinach);
        nutriments.add(bacon);
        nutriments.add(cheese);
        nutriments.add(bread);
        nutriments.add(noodles);
        nutriments.add(tomatoJuice);
        nutriments.add(water);

        Meal omelette = new Meal("Omelette");
        omelette.add(new Food(eggs), 150);
        omelette.add(new Food(bacon), 50);

        Meal sandwich = new Meal("Sandwich");
        sandwich.add(new Food(bread), 150);
        sandwich.add(new Food(eggs), 70);
        sandwich.add(new Food(bacon), 50);
        sandwich.add(new Food(cheese), 30);

        Meal tomatoSoup = new Meal("Tomato_Soup");
        tomatoSoup.add(new Drink(water), 400);
        tomatoSoup.add(new Drink(tomatoJuice), 150);
        tomatoSoup.add(new Food(noodles), 100);

        Meals menu = new Meals();
        menu.add(omelette);
        menu.add(sandwich);
        menu.add(tomatoSoup);

        while (true) {
            System.out.println("0: [Quit Program] 1: [Enter fridge] 2: [Enter menu] 3: [Enter nutriments]");
            int x = sc.nextInt();
            if (x == 0)
                break;
            switch (x) {
                case 1: // ENTER FRIDGE
                    while (true) {
                        if (fridge.getNutriments().size() == 0)
                            System.out.println("\nYour fridge is empty!");
                        else
                            System.out.println(fridge.showAll());
                        System.out.println();
                        System.out.println("0: [Back] 1: [Add nutriment] 2: [Remove nutriment] 3: [Meals you can create]");
                        int y = sc.nextInt();
                        if (y == 0)
                            break;
                        switch (y) {
                            case 1: // ADD NUTRIMENT
                                while (true) {
                                    System.out.println(nutriments);
                                    System.out.println();
                                    System.out.println("Which nutriment do you want to add?");
                                    String name = sc.next();
                                    for (Nutriment n : nutriments) {
                                        if (name.equals(n.getName())) {
                                            System.out.println("How much weight do you want?");
                                            double weight = sc.nextDouble();
                                            fridge.add(n, weight);
                                            System.out.println("Nutriment successfully added in fridge!");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                break;
                            case 2: // REMOVE NUTRIMENT
                                while (true) {
                                    if (fridge.getNutriments().size() == 0)
                                        break;
                                    System.out.println(fridge.showAll());
                                    System.out.println();
                                    System.out.println("Which nutriment do you want to remove?");
                                    String name = sc.next();
                                    for (Nutriment n : nutriments) {
                                        if (name.equals(n.getName())) {
                                            System.out.println("0: [Remove whole nutriment] 1: [Remove a portion]");
                                            int z = sc.nextInt();
                                            if (z == 0) {
                                                fridge.remove(n);
                                                System.out.print("Nutriment successfully removed!");
                                                break;
                                            }
                                            else if (z == 1) {
                                                System.out.println("How much do you want to remove?");
                                                double weight = sc.nextDouble();
                                                fridge.remove(n, weight);
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }
                                break;
                            case 3:
                                if (menu.search(fridge.getNutriments()).size() > 0)
                                    System.out.println(menu.search(fridge.getNutriments()));
                                else
                                    System.out.println("You dont have enough nutriments to create a meal!");
                                System.out.println("0: [Back]");
                                int z = sc.nextInt();
                                if (z == 0)
                                    break;
                        }
                    }
                    break;
                case 2: // ENTER MENU
                    while (true) {
                        if (menu.toString().length() == 0)
                            System.out.println("\nYou have no meal in menu!");
                        else {
                            System.out.println("Menu:");
                            System.out.println(menu);
                        }

                        System.out.println();
                        System.out.println("0: [Back] 1: [Add new meal] 2: [Remove meal] 3: [Show meal nutriments] 4: [Search meal by kcal]");
                        int y = sc.nextInt();
                        if (y == 0)
                            break;
                        switch (y) {
                            case 1: // ADD NEW MEAL
                                while (true) {
                                    System.out.println("Enter meal name");
                                    String mealName = sc.next();
                                    Meal meal = new Meal(mealName);
                                    int z = -1;
                                    while (z != 1) {
                                        System.out.println(nutriments);
                                        System.out.println();
                                        System.out.println("What nutriment will this meal contain?");
                                        String name = sc.next();
                                        for (Nutriment n : nutriments) {
                                            if (name.equals(n.getName())) {
                                                System.out.println("How much grams of this nutriment do you want?");
                                                double weight = sc.nextDouble();
                                                meal.add(n, weight);
                                                System.out.println("Nutriment successfully added in meal!");
                                                break;
                                            }
                                        }
                                        System.out.println("Do you want to add another nutriment in meal?");
                                        System.out.println("0: [Yes] 1: [No]");
                                        z = sc.nextInt();
                                        if (z == 0)
                                            continue;
                                        else if (z == 1)
                                            break;
                                    }
                                    menu.add(meal);
                                    System.out.println("Meal successfully added in menu!");
                                    break;
                                }
                                break;
                            case 2: // REMOVE MEAL
                                while (true) {
                                    if (menu.toString().length() == 0)
                                        break;
                                    System.out.println(menu);
                                    System.out.println("Which meal do you want to remove from menu?");
                                    String mealName = sc.next();
                                    menu.remove(mealName);
                                    System.out.print("Meal successfully removed from menu!");
                                    break;
                                }
                                break;
                            case 3: // SHOW MEAL NUTRIMENTS
                                while (true) {
                                    System.out.println("For which meal do you want to see nutriments?");
                                    System.out.println(menu + "");
                                    String mealName = sc.next();
                                    menu.showMealNutriments(mealName);
                                    System.out.println();
                                    System.out.println("0: [Back]");
                                    int z = sc.nextInt();
                                    if (z == 0)
                                        break;
                                }
                                break;
                            case 4: // SEARCH MEAL
                                while (true) {
                                    if (menu.toString().length() == 0)
                                        break;
                                    System.out.println("Max amount of kcal you want your meal to have:");
                                    double kcal = sc.nextDouble();
                                    if (menu.search(kcal).size() == 0)
                                        System.out.println("No meal avaiable!");
                                    else
                                        System.out.println(menu.search(kcal));
                                    System.out.println("Do you want to search again?");
                                    System.out.println("0: [Yes] 1: [No]");
                                    int z = sc.nextInt();
                                    if (z == 1)
                                        break;
                                }
                        }
                    }
                    break;
                case 3: // ENTER NUTRIMENTS
                    while (true) {
                        if (nutriments.size() == 0)
                            System.out.println("You have no nutriments avaiable!");
                        else
                            System.out.println(nutriments);
                        System.out.println();
                        System.out.println("0: [Back] 1: [Add nutriment] 2: [Remove nutriment]");
                        int y = sc.nextInt();
                        if (y == 0)
                            break;
                        switch (y) {
                            case 1: // ADD NUTRIMENT
                                while (true) {
                                    System.out.println("0: [Back] 1: [Food] 2: [Drink]");
                                    int addNutriment = sc.nextInt();
                                    if (addNutriment == 0)
                                        break;

                                    System.out.println("Enter nutriment name");
                                    String name = sc.next();
                                    System.out.println("Enter kcal");
                                    double kcal = sc.nextDouble();
                                    System.out.println("Enter proteins");
                                    double proteins = sc.nextDouble();
                                    System.out.println("Enter carbohydrates");
                                    double carbohydrates = sc.nextDouble();
                                    System.out.println("Enter fats");
                                    double fats = sc.nextDouble();
                                    System.out.println("Enter fiber");
                                    double fiber = sc.nextDouble();
                                    System.out.println();

                                    if (addNutriment == 1) {
                                        nutriments.add(new Food(name, kcal, proteins, carbohydrates, fats, fiber));
                                        System.out.println("Food successfully added!");
                                    }
                                    else if (addNutriment == 2) {
                                        nutriments.add(new Drink(name, kcal, proteins, carbohydrates, fats, fiber));
                                        System.out.println("Drink successfully added!");
                                    }
                                    break;
                                }
                                break;
                            case 2: // REMOVE NUTRIMENT
                                if (nutriments.size() == 0)
                                    break;
                                System.out.println(nutriments);
                                System.out.println();
                                System.out.println("Enter name of nutriment you want to remove");
                                String name = sc.next();
                                for (Nutriment n : nutriments) {
                                    if (name.equals(n.getName())) {
                                        nutriments.remove(n);
                                        System.out.println("Nutriment successfully removed!");
                                        break;
                                    }
                                }
                        }
                    }
            }
        }

    }
}
