public class Drink extends Nutriment{
    public Drink(String company, String name, double kcal, double proteins, double carbohydrates, double fats, double fiber) {
        super(company, name, kcal, proteins, carbohydrates, fats, fiber);
    }

    public Drink(String name, double kcal, double proteins, double carbohydrates, double fats, double fiber) {
        super(name, kcal, proteins, carbohydrates, fats, fiber);
    }

    public Drink(Drink d) {
        this(d.getName(), d.getKcal(), d.getProteins(), d.getCarbohydrates(), d.getFats(), d.getFiber());
    }
}
