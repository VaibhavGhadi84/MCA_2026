public class Customer {
    private String id;
    private String name;
    private String address;
    private String phoneNo;

    public Customer(String id, String name, String address, String phoneNo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public void buyProduct(Product product) {
        System.out.println(this.name + " bought " + product.getName());
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhoneNo() { return phoneNo; }
}