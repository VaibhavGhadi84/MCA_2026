public class Product {
    private String id;
    private String name;
    private double price;
    private String categories;

    public Product(String id, String name, double price, String categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = categories;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategories() { return categories; }
}