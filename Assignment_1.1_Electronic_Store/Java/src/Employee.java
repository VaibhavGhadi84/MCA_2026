public class Employee {
    private String id;
    private String name;
    private double salary;

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void sellProduct(Product product, Customer customer) {
        System.out.println(this.name + " sold " + product.getName() + " to " + customer.getName());
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
}