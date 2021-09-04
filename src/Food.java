public class Food extends Nutriment{
    public Food(String company, String name, double kcal, double proteins, double carbohydrates, double fats, double fiber) {
        super(company, name, kcal, proteins, carbohydrates, fats, fiber);
    }

    public Food(String name, double kcal, double proteins, double carbohydrates, double fats, double fiber) {
        super(name, kcal, proteins, carbohydrates, fats, fiber);
    }

    public Food(Food f) {
        this(f.getName(), f.getKcal(), f.getProteins(), f.getCarbohydrates(), f.getFats(), f.getFiber());
    }
}
