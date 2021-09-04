public abstract class Nutriment extends Grocery {
    private int id = 1;
    private double weight;
    private double kcal; //kalorije na 100g
    private double proteins; //proteini na 100g
    private double carbohydrates;
    private double fats;
    private double fiber;

    public Nutriment(String company, String name, double kcal, double proteins, double carbohydrates, double fats, double fiber) {
        super(company, name);
        this.kcal = kcal;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.fiber = fiber;
    }

    public Nutriment(String name, double kcal, double proteins, double carbohydrates, double fats, double fiber) {
        super(name);
        this.kcal = kcal;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.fiber = fiber;
    }

    public void update(Double weight, Double kcal, Double proteins, Double carbohydrates, Double fats, Double fiber) {
        if (weight != null)
            this.weight = weight;
        if (kcal != null)
            this.kcal = kcal;
        if (proteins != null)
            this.proteins = proteins;
        if (carbohydrates != null)
            this.carbohydrates = carbohydrates;
        if (fats != null)
            this.fats = fats;
        if (fiber != null)
            this.fiber = fiber;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public double getKcal() {
        return kcal;
    }

    public double getProteins() {
        return proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFats() {
        return fats;
    }

    public double getFiber() {
        return fiber;
    }

    public double getTotalKcal() {
        return weight / 100 * kcal;
    }

    public double getTotalProteins() {
        return weight / 100 * proteins;
    }

    public double getTotalCarbohydrates() {
        return weight / 100 * carbohydrates;
    }

    public double getTotalFats() {
        return weight / 100 * fats;
    }

    public double getTotalFiber() {
        return weight / 100 * fiber;
    }


    @Override
    public String toString() {
        return super.toString() + " | Kcal: " + kcal + " | Proteins: " + proteins +
                "% | Carbohydrates: " + carbohydrates + "% | Fats: " + fats + "% | Fiber: " + fiber + "%";
    }

    public String totalNutrientTable() {
        return super.toString() + "\nWeight: " + weight + "g\nKcal: " + getKcal() + "\nProteins: " +
                getTotalProteins() + "g\nCarbohydrates: " + getTotalCarbohydrates() +
                "g\nFats: " + getTotalFats() + "g\nFiber: " + getTotalFiber();
    }

}
