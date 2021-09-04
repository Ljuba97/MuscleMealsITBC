import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Fridge {
    private List<Nutriment> nutriments;

    public Fridge() {
        nutriments = new ArrayList<>();
    }

    public Fridge(List<Nutriment> nutriments) {
        this.nutriments = nutriments;
    }

    public List<Nutriment> getNutriments() {
        return nutriments;
    }

    public void add(Nutriment n, double weight) {
        if (!nutriments.contains(n)) {
            n.setWeight(weight);
            nutriments.add(n);
        }
        else {
            for (Nutriment x : nutriments) {
                if (x.equals(n)) {
                    x.setWeight(x.getWeight() + weight);
                    return;
                }
            }
        }
    }

    public void remove(Nutriment n) {
        nutriments.remove(n);
    }

    public void remove(Nutriment n, double weight) {
        for (Nutriment x : nutriments) {
            if (x.equals(n)) {
                if (x.getWeight() - weight > 0)
                    x.setWeight(x.getWeight() - weight);
                else
                    nutriments.remove(x);
                return;
            }
        }
    }

    public String showAll() {
        StringBuilder sb = new StringBuilder();
        for (Nutriment n : nutriments)
            sb.append(n.getName()).append(" - ").append(n.getWeight()).append("g | ");
        if (sb.length() > 0)
            return sb.substring(0, sb.length() - 2);
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Fridge{" +
                "nutriments=" + nutriments +
                '}';
    }
}
