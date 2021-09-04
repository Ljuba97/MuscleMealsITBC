import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Meal implements Energy{
    private UUID id = UUID.randomUUID();
    private List<Nutriment> nutriments; //sve sto ide u neko jelo
    private String name; //ime jela

    public Meal(List<Nutriment> nutriments, String name) {
        this.nutriments = nutriments;
        this.name = name;
    }

    public Meal(String name) {
        nutriments = new ArrayList<>();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Nutriment> getNutriments() {
        return nutriments;
    }

    public void add(Nutriment n, double weight) {
        for (Nutriment x : nutriments) {
            if (x.equals(n)) {
                x.setWeight(x.getWeight() + weight);
                return;
            }
        }
        n.setWeight(weight);
        nutriments.add(n);
    }

    public void remove(Nutriment n) {
        nutriments.remove(n);
    }

    public void remove(Nutriment n, double weight) {
        for (Nutriment x : nutriments) {
            if (x.equals(n)) {
                if (x.getWeight() - weight <= 0) {
                    nutriments.remove(x);
                    return;
                }
                x.setWeight(x.getWeight() - weight);
                return;
            }
        }
    }

    public double getWeight() {
        double sum = 0;
        for (Nutriment n : nutriments)
            sum += n.getWeight();
        return sum;
    }

    @Override
    public double getKcal() {
        double sum = 0;
        for (Nutriment n : nutriments)
            sum += n.getTotalKcal();
        return sum;
    }

    public double getProteins() {
        double sum = 0;
        for (Nutriment n : nutriments)
            sum += n.getTotalProteins();
        return sum;
    }

    public double getCarbohydrates() {
        double sum = 0;
        for (Nutriment n : nutriments)
            sum += n.getTotalCarbohydrates();
        return sum;
    }

    public double getFats() {
        double sum = 0;
        for (Nutriment n : nutriments)
            sum += n.getTotalFats();
        return sum;
    }

    public double getFiber() {
        double sum = 0;
        for (Nutriment n : nutriments)
            sum += n.getTotalFiber();
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Objects.equals(id, meal.id);
    }

    @Override
    public String toString() {
        return name;
    }
}
