import java.util.Objects;

public abstract class Grocery implements Energy {
    private String company;
    private String name;

    public Grocery(String company, String name) {
        this.company = company;
        this.name = name;
    }

    public Grocery(String name) {
        company = "Domestic product";
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grocery grocery = (Grocery) o;
        return Objects.equals(company, grocery.company) && Objects.equals(name, grocery.name);
    }

    @Override
    public String toString() {
        return "\nName: " + name;
    }
}
