import java.util.ArrayList;
import java.util.List;

public class Meals {
    private List<Meal> menu;

    public Meals() {
        menu = new ArrayList<>();
    }

    public boolean add(Meal m) {
        if (!menu.contains(m)) {
            menu.add(m);
            return true;
        }
        return false;
    }

    public void remove(Meal m) {
        menu.remove(m);
    }

    public void remove(String name) {
        for (Meal m : menu) {
            if (name.equals(m.getName())) {
                menu.remove(m);
                break;
            }
        }
    }

    public List<Meal> search(String s) {
        List<Meal> list = new ArrayList<>();
        for (Meal m : menu) {
            if (m.getName().contains(s))
                list.add(m);
        }
        return list;
    }

    public List<Meal> search(List<Nutriment> nutriments) {
        List<Meal> res = new ArrayList<>();
        for (Meal m : menu) {
            boolean flag = true;
            for (int i = 0; i < m.getNutriments().size(); i++) {
                if (!(nutriments.contains(m.getNutriments().get(i)) &&
                        m.getNutriments().get(i).getWeight()
                                <= nutriments.get(nutriments.indexOf(m.getNutriments().get(i))).getWeight())) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                res.add(m);
        }
        return res;
    }

    public List<Meal> search(double kcal) {
        List<Meal> list = new ArrayList<>();
        for (Meal m : menu) {
            if (m.getKcal() < kcal)
                list.add(m);
        }
        return list;
    }

    public List<Meal> search(String name, Double weight, Double kcal, Double proteins, Double carbohydrates, Double fats, Double fiber) {
        List<Meal> list = new ArrayList<>();
        if (weight == null && kcal == null && proteins == null && carbohydrates == null && fats == null && fiber == null)
            return list;
        for (Meal m : menu) {
            if ((name == null || m.getName().contains(name)) && (weight == null || m.getWeight() <= weight)
            && (kcal == null || m.getKcal() <= kcal) && (proteins == null || m.getProteins() <= proteins)
            && (carbohydrates == null || m.getCarbohydrates() <= carbohydrates) && (fats == null || m.getFats() <= fats)
            && (fiber == null || m.getFiber() <= fiber))
                list.add(m);
        }
        return list;
    }

    public void showMealNutriments(String name) {
        for (Meal m : menu) {
            if (name.equals(m.getName())) {
                System.out.println(m.getNutriments());
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Meal m : menu) {
            sb.append(m.getName()).append(" | ");
        }
        if (sb.length() > 0)
            return sb.substring(0, sb.length() - 2);
        return sb.toString();
    }
}
