package project5;

public class Wearable {

    private int ranking;
    private String name;
    private Double price;
    private String bodyLocation;
    private String category;
    private Company company;

    public Wearable(int ranking, String name, Double price, String bodyLocation, String category, Company company) {
        this.ranking = ranking;
        this.name = name;
        this.price = price;
        this.bodyLocation = bodyLocation;
        this.category = category;
        this.company = company;
    }

    public int getRanking() {
        return ranking;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getBodyLocation() {
        return bodyLocation;
    }

    public String getCategory() {
        return category;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Wearable{" + "ranking=" + ranking + ", name=" + name + ", price=" + price + ", bodyLocation=" + bodyLocation + ", category=" + category + ", company=" + company + '}';
    }

    public Wearable(int ranking, Double price, String name) {
        this.ranking = ranking;
        this.name = name;
        this.price = price;
    }

}
